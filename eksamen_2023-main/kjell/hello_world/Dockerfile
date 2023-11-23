# Velger Python 3.9 som baseimage
FROM python:3.9

# Definerer arbeidsmappen i containeren
WORKDIR /arbeidsmappe

# Kopierer kravene for Python-pakker og installerer dem
COPY requirements.txt ./
RUN pip install --no-cache-dir -r requirements.txt

# Kopierer resten av applikasjonen til arbeidsmappen i containeren
COPY . .

# Kommandoen som kjører når containeren starter
CMD ["python", "app.py"]
