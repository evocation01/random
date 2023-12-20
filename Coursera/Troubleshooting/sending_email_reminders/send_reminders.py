""" A python script that sends e-mail reminders, with args 'date, title, email' """


import argparse
import datetime
import email
import email.message
import logging
import smtplib
import sys

logging.basicConfig(level=logging.INFO)

DEFAULT_EMAILS = {
    "hakan": "hakanispir2004@gmail.com",
    "ege": "egeaslan147@gmail.com",
    "hüd": "hudayeniocak04@hotmail.com",
}

SMTP_CONFIG = {
    "server": "smtp.gmail.com",
    "port": 587,
    "username": "hakanispir2004@gmail.com",
    "password": "ywnw yeiu eusf xgxb",
}


def resolve_email(name_or_alias):
    """Resolve a name or alias to a default email address"""
    return DEFAULT_EMAILS.get(name_or_alias.lower(), name_or_alias)


def usage():
    """Creates some log statements for better understanding"""

    logging.error(
        "Invalid invocation. Example: send_reminders 'date|Meeting Title|Emails'"
    )
    return 1


def dow(date):
    """Creates dow"""

    dateobj = datetime.datetime.strptime(date, r"%d/%m/%Y")

    return dateobj.strftime("%A")


def message_template(date: str, title: str):
    """Create the message"""
    message = email.message.EmailMessage()
    weekday = dow(date)
    message["Subject"] = f'Meeting reminder: "{title}"'
    message.set_content(
        f"""
Hi all!

This is a quick mail to remind you all that we have a meeting about:

{title}

on {weekday}, {date}.

See you there.
"""
    )
    return message


def send_message(message, emails):
    """Create a function to send the 'message' to the designated email"""

    try:
        smtp = smtplib.SMTP(SMTP_CONFIG["server"], SMTP_CONFIG["port"])
        smtp.starttls()
        smtp.login(SMTP_CONFIG["username"], SMTP_CONFIG["password"])
        message["From"] = "noreply@example.com"

        for recipient_email in emails:
            del message["To"]
            message["To"] = recipient_email
            smtp.send_message(message)
        smtp.quit()

    except Exception as e:
        print(f"Error sending email: {e}", file=sys.stderr)


def parse_arguments():
    """Create parse arguments, set some types and add help/description options"""

    parser = argparse.ArgumentParser(description="Send email reminders.")
    parser.add_argument(
        "input_string",
        type=str,
        help='Input string in the format "date|Meeting Title|Emails"',
    )
    args = parser.parse_args()

    # Split the input string using '|' and unpack the values
    try:
        date, title, emails = args.input_string.split("|")
        return date, title, emails
    except ValueError:
        return None, None, None


def main():
    """Main function"""
    date, title, emails = parse_arguments()

    if (date is None) or (title is None) or (emails is None):
        return usage()

    try:
        resolved_emails = [resolve_email(name) for name in emails.split(",")]
        message = message_template(date, title)
        send_message(message, resolved_emails)  # Use resolved_emails here

        logging.info("Successfully sent reminders to: %s", ", ".join(resolved_emails))

    except Exception as e:
        logging.error("Failure to send email due to: %s", e)


if __name__ == "__main__":
    sys.exit(main())
