# Velger Python 3.9 som baseimage
FROM python:3.9

# Definer miljøvariabler (du kan sette disse i GitHub Actions Secrets)
# Sett riktige verdier for AWS_SECRET_ACCESS_KEY_ID og AWS_SECRET_ACCESS_KEY
# ENV AWS_SECRET_ACCESS_KEY_ID=your_access_key_id
# ENV AWS_SECRET_ACCESS_KEY=your_secret_access_key

# Set the default bucket name inside the Dockerfile
ENV BUCKET_NAME=2032sinbucket

# Sett arbeidsmappen i containeren
WORKDIR /app

# Kopier kravene for Python-pakker og installer dem
# Anta at du har en requirements.txt i hello_world-mappen som lister opp alle avhengighetene
COPY kjell/hello_world/requirements.txt ./
RUN pip install --no-cache-dir -r requirements.txt

# Kopier resten av applikasjonen til arbeidsmappen i containeren
COPY kjell/hello_world/ .

# Kommandoen som kjører når containeren starter (dette vil kjøre din AWS SAM-applikasjon)
CMD ["sam", "local", "start-api", "--host", "0.0.0.0"]
