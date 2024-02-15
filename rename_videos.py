import os
import re


def rename_videos(directory, old_pattern, new_name):
    pattern = re.compile(old_pattern)

    for filename in os.listdir(directory):
        if filename.endswith(".mp4"):
            if pattern.search(filename):
                new_filename = pattern.sub(new_name, filename)
                old_file_path = os.path.join(directory, filename)
                new_file_path = os.path.join(directory, new_filename)

                # Debug print
                print(f"Attempting to rename: {old_file_path} to {new_file_path}")

                try:
                    os.rename(old_file_path, new_file_path)
                    print(f"Renamed '{filename}' to '{new_filename}'")
                except FileNotFoundError as e:
                    print(f"Error: {e}")
                except Exception as e:
                    print(f"Unexpected error: {e}")


from pathlib import Path

directory_path = Path("D:/PC/HAKAN/cs2d/bots/inc/CS2DD/vids/try")

rename_videos(directory_path, r"THROAT-R", "THR")
