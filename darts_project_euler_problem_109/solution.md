Darts - Problem 109
Project Euler
1 dart
Hur många sätt kan jag avsluta på en dart?
2 darts
Hur många sätt kan jag ta mig till en nedanstående nivå där jag kan avsluta på ett kast?
3 darts
Vilka dubbelkombinationer finns det som tar mig till en lägre nivå som jag kan avsluta på? Alla dubbelkombinationer innehållande samma träffar räknas som en kombination och inte två. 
Algoritm
För nivå 1-99 räkna ut hur många sätt jag kan avsluta på ett kast.
För varje score räkna ut hur många sätt jag kan kasta en dart för att ta mig till en score där jag kan avsluta direkt. 
Räkna ut alla dubbelkombinationer som finns som är mindre än 99.
För varje score undersök hur många dubbelkombinationer som finns som tar score till en score som det går att avsluta ifrån. 
Plusa ihop: 
direktavslut på nuvarande score
Summan av: (en dart till en viss direktavslut score x)*(antal direktavslut för score x) för alla möjliga x.
Summan av antalet direktavslut för varje score som blir för varje dubbelkombination. Summan av: (antal direktavslut för score x)*(dubbelkombinationer som gör att scoren landar på x), för alla möjliga x.

För varje nivå 1-99 vill jag veta hur många direktavslut som finns. Noll om inga finns. 
För alla värden mellan 1-98 vill jag veta vilka enskilda pilkast som ger det värdet. I stigande värde. Alltså ska S1 ligga först sen S2 och D1 osv.. På något sätt vill jag också markera att ett kast ger värdet 1 och två kast ger värdet 2. 
Gör exakt samma sak med dubbelkombinationer. 
För varje nivå räkna ut antalet variationer

Komplexitet:
Punkt 1: 21*50 (ger lista på längd 99)
Punkt 2: 62 (lista på längd 62 eller 99)
Punkt 3: 3782 (lista på längd 99)
Punkt 4: 99*(1+60+98)

