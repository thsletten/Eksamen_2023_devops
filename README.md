# EksamenRep_2023
Eksamen i dev ops i skyende 2023

note: Jeg hadde problemer og fikk feilen:  "403 feil fra  spring-boot applikasjonen"
når jeg skulle teste applikasjonen når jeg beggynte på oppgave 4. Jeg så det ble lagt ut en melding om denne feilen men jeg fikk ikke løsnigen til å fungere. Til torss for dette tror jeg at jeg har klart å løse oppgavene til ett vis nivå.

Dette er min løsning på eksamen oppgaven:




oppgave 1: FORKLARIN: 

1. **Fork Repository**: Klikk på 'Fork'-knappen på hovedsiden til repositoryet.
2. **Aktiver GitHub Actions**: Gå til 'Actions'-fanen i det nye repositoryet og aktiver workflows.

4. **Kjør Workflow**: Utløs workflowen manuelt fra 'Actions'-fanen, eller la den kjøre automatisk ved push eller pull request.

Husk å overvåke bruken av Actions for å unngå ekstra kostnader. 😊


Oppgave 4 dokementasjon
AWS Rekognition Integrasjon
Applikasjonen bruker AWS Rekognition for å skanne bilder lagret i en AWS S3 Bucket for å oppdage PPE-brudd.

Endepunkt
GET /scan-ppe: Dette endepunktet tar en S3 Bucket-navn som parameter og returnerer analyseresultater av bilder for PPE-deteksjon.
Installasjon og Kjøring
For å kjøre applikasjonen med AWS Rekognition-funksjonalitet:
Klone prosjektet fra git-repository.
Sett opp AWS-referanser og S3 Bucket-detaljer i application.properties.
Bruk mvn spring-boot:run for å starte applikasjonen.
Bruk
For å utføre en PPE-skanning på en S3 Bucket, send en GET-forespørsel til /scan-ppe med Bucket-navnet som parameter.


Oppgave 5* Drøfte oppgaven.
A. Kontinuerlig Integrering

CI står for Continuous Integration og er en praksis som kan brukes når et lag med folk skal utvikle et produkt innen IT bransjen. CI går ut på at endringer i prosjekt koden skjer jevnt og trutt. 
dette gjør at flere folk kan jobbe med samme oppdaterte kode. Dette skjer ved at folk laster opp sine endringer i ett kodearkiv som f.eks Github. Og kan laste ned oppdaterte versjonene som inkluderer alle endringer resten av laget har utført. Det er normalt og laste opp endringer flere ganger om dagen.
CI gir veldig store fordeler ovenfor andre utviklings praksiser. Hver gang man laster opp koden(pusher) så vil automatiske tester skjøre for å se om det er feil i koden du lastet opp eller om det er noen konflikter med eksisterende kode. Når disse testene kjører hver gang man laster opp kode som blir mange ganger på en dag vil feilene være små og derfor lettere og fikse. Med CI vil også kodekvaliteten øke. Når man jobber i et tett lag må man sørge for at alle følger de samme standardene og praksisene for kodekvalitet og designmønstre. Dette sikres gjennom CI-prosessen, hvor kodegjennomganger, kodeanalyseverktøy og automatiserte tester spiller en nøkkelrolle. Man er også flere folk som ser samme koden.Dette fører til flere øyne på de samme problemene som vil føre til flere og bedre løsninger enn en person kunne klart alene. Samtidig som CI gir mange tekniske fordeler, gjør CI det mer spennende for utviklere ved å fremme et dynamisk og samarbeidsorientert arbeidsmiljø. Med CI blir utviklere kontinuerlig utfordret til å forbedre og tilpasse seg, da de stadig mottar tilbakemelding på arbeidet sitt.
I et utviklingsteam på fire eller fem personer som jobber med CI i GitHub, innebærer det å ha et sentralt repositorium hvor alle medlemmer laster opp sine endringer. Det er vanlig å oprette en egen branch som man kan jobbe med sin utvalgte oppgave. Ved å bruke pull requests og code reviews sikres det at kode blir sett igjenom før bracnhen merges med main.

B. Sammenligning av Scrum/Smidig og DevOps fra et Utviklers Perspektiv
Scrum/Agile er en form for prosjektstruktur som fremmer interaktiv utvikling i deler. Scrum/Agile handler om å dele hovedoppgaven inn i mye mindre deler. Disse mindre oppgavene blir valgt i starten av hver økt (også kalt sprint). Lengden på en sprint kan variere avhengig av prosjekttypen og hvem som utfører prosjektet, men en vanlig lengde for en sprint er mellom 2-4 uker. Scrum/Agile inneholder møter i starten av alle dager for å se hvordan folk i laget ligger an, slik at arbeidskraften kan fordeles ut hvis noen har problemer. Det er også et større møte i starten av hver sprint, der større oppgaver deles opp og det avgjøres hvem som skal gjøre hva. Kanskje den største fordelen med denne måten å jobbe på er at den er veldig fleksibel. Hvis hovedoppgaven endrer seg eller funksjoner blir lagt til, kan man raskt tilpasse arbeidsplanen og prioriteringene i starten av neste sprint. I stedet for å være bundet til en fast plan, tillater Scrum/Agile teamet å revurdere fremgangen og endre fokus basert på ny informasjon eller kundetilbakemeldinger. Dette sikrer at sluttproduktet forblir relevant for kunden, selv i et raskt skiftende marked.

Noen av utfordringene er å tilpasse seg prosjektets endrende prioriteringer, samt å opprettholde god kommunikasjon mellom medlemmene i gruppen. Dette stiller krav til teammedlemmenes evne til å disiplinere og organisere seg selv.

DevOps handler om å integrere programvareutvikling og IT-drift for å forbedre samarbeid og øke effektiviteten i utviklingsprosesser. Noe av det viktigste med DevOps er automatisering og kontinuerlig integrering og levering (CI/CD), som sikrer en effektiv flyt fra kodeutvikling til produktet. Denne tilnærmingen legger vekt på rask tilbakemelding og endringer, noe som hjelper med å identifisere og rette feil tidlig, og dermed forbedre produktkvaliteten.

Implementering av DevOps fører til raskere utvikling og utrulling av produkter, som gjør bedrifter mer smidige og konkurransedyktige. Mens denne overgangen øker samarbeid og gir en rask respons på markedsendringer, innebærer den også utfordringer som kulturendringer i organisasjonen. I tillegg innebærer DevOps også mer teknisk kompleksitet enn andre arbeidsmetoder. DevOps transformerer dermed ikke bare utviklings- og driftsprosesser, men også den generelle bedriftskulturen, med fokus på kontinuerlig forbedring og effektivitet.

Scrum/Smidig og DevOps er begge viktige metodikker for å utvikle programvarer, men de håndterer programvarekvalitet og leveransetempo på forskjellige måter. Scrum/Agile, med sin iterative tilnærming som deler store oppgaver i mindre deler og utfører dem i sprints, fremmer fleksibilitet og tilpasningsevne. Dette bidrar til forbedret programvarekvalitet ved å tillate raske justeringer og fremmer et raskt leveransetempo gjennom kontinuerlig feedback og teamkommunikasjon. Med DevOps er det fokus på integrering av utvikling og drift gjennom automatisering og kontinuerlig integrering/levering (CI/CD). DevOps sikrer raskere utvikling og oppdatering av koden, samtidig som det opprettholder høy kvalitet gjennom hele prosessen. Kort sagt, prosessen i Scrum/Agile er delt opp i perioder (sprinter) der det er flyt i sprinten, men ikke mellom. Fokuset for programmererne skal ligge i sprinten, og systemer og applikasjoner skal fungere selvstendig. I DevOps er målet å ha en flyt gjennom større deler av prosjektet med fokus også lengre frem.

Et eksempel på hvordan de er forskjellige kan være hvordan de håndterer sammenslåing av kode. I Scrum/Agile kan en del av prosessen være å sette av 1-2 dager på slutten av sprinten kun til merging av all koden som er produsert. Mens i DevOps vil dette skje jevnt og trutt ettersom man produserer kode.

Begge metodene er nyttige i ulike utviklingssituasjoner. Scrum/Smidig passer best i prosjekter med hyppige og raske endringer og hvor kundefeedback er sentral, mens DevOps er ideell for større prosjekter som krever raske oppdateringer, og hvor det er fokus på effektivitet og sikkerhet. Valget mellom disse metodikkene avhenger av prosjektets natur, teamets oppbygging, og mål.

Oppgave C. Det andre prinsippet - feedback.

Når man implementerer ny funksjonalitet i en applikasjon, er det viktig å lage et feedback system for å sikre at funksjonaliteten møter brukernes krav. Dette kan man gjøre ved hjelp av brukertesting, hvor representative brukere gir direkte tilbakemeldinger på funksjonaliteten. I tillegg til brukertesting kan man bruke surveys og spørreskjemaer for å samle detaljert og strukturert feedback. Analyseverktøy integrert i applikasjonen kan også bidra til å samle kvantitative data om brukerinteraksjoner, som kan gi innsikt i hvordan funksjonaliteten faktisk brukes.

Bruk av feedback er viktig for forbedring av funksjonaliteten. Ved å integrere brukernes tilbakemeldinger i utviklingsprosessen kan justeringer og forbedringer gjøres for å bedre tilpasse funksjonaliteten til brukernes behov og forventninger. Feedback bør integreres både under utvikling gjennom prototyper og etter lansering, for kontinuerlig å overvåke og forbedre funksjonaliteten. Dette sikrer at produktet forblir relevant og verdifullt for brukerne over tid.






