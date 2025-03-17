import sqlite3
import requests
from bs4 import BeautifulSoup

URL = "https://en.wikipedia.org/wiki/Palearctic_realm"
r = requests.get(URL)

from bs4 import BeautifulSoup
soup = BeautifulSoup(r.content, 'html5lib')

content = []  

main_content = soup.find('div', attrs={'class': 'mw-parser-output'})
if main_content:
    for section in main_content.find_all(['h2', 'h3', 'p'], recursive=False):
        if section.name == 'h2' or section.name == 'h3':  
            content.append({'type': 'heading', 'text': section.text.strip()})
        elif section.name == 'p':  
            content.append({'type': 'paragraph', 'text': section.text.strip()})

conn = sqlite3.connect('content.db')  
cursor = conn.cursor()

cursor.execute('''
CREATE TABLE IF NOT EXISTS Content (
    id INTEGER PRIMARY KEY,
    type TEXT,
    text TEXT
)
''')


for item in content:
    cursor.execute('INSERT INTO Content (type, text) VALUES (?, ?)', (item['type'], item['text']))


conn.commit()
conn.close()

print("Data has been successfully inserted into the database.")
