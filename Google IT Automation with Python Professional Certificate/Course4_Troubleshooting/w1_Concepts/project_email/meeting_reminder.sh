#!/bin/bash

meeting_info=$(zenity --forms \
    --title "Meeting" --text "Reminder information" \
    --add-calendar "Date" --add-entry "Title" \
    --add-entry "Emails" \
    --forms-date-format='%d/%m/%Y' \
    2>/dev/null)

echo $meeting_info

if [[ -n "$meeting_info" ]]; then
    python send_reminders.py "$meeting_info"
fi