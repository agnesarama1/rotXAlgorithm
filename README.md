# rotX - Algorithm
Projekti i dytë nga lënda "Siguria e të dhënave".



Kodi rotX është një algoritëm i thjeshtë për të enkriptuar mesazhe duke zëvendësuar çdo shkronjë me shkronjën që ndodhet X pozicione më tej në alfabet. Përdoruesi zgjedh vlerën e X-it dhe algoritmi punon sipas kësaj vlerë. Ndër algoritmet më të njohura ROTX është ROT13, ku X është 13. Ky algoritëm është i ngjashëm me kodin e Cezarit të Romës së lashtë, por është anasjelltas me të, pasi ai ka 26 shkronja në alfabetin latin dhe punon me një shifër të vetme për çdo shkronjë dhe kërkon vetëm 26 variantet e mundshme dhe kjo bën që ROT13 të jetë më i përshtatshëm për kodim dhe dekodim.
Mirëpo, ROTX ende është i prekshëm për shkelje të lehtë të sigurisë sepse nuk ofron siguri të lartë kibernetike. Shpesh referohet edhe si shembull i dobët i enkriptimit.

Ky algoritëm është një shembull i thjeshtë i enkriptimit dhe dekriptimit të tekstit duke përdorur algoritmin simetrik AES (Advanced Encryption Standard - a symmetric block cipher algorithm with a block/chunk size of 128 bits). Në këtë algoritëm, programi kërkon nga shfrytëzuesi të specifikojë një vlerë input të tekstit që dëshiron të enkriptojë, pastaj kërkon gjatësinë e çelësit simetrik (16, 24 ose 32 byte) dhe në fund rotacionin e alfabetit të caktuar nga përdoruesi.

Në këtë program kemi të implementuar një funksion për enkriptim të tekstit të dhënë nga shfrytëzuesi, përmes të cilit pasi merren të dhënat nga shfrytëzuesi programi bën enkriptimin e tekstit duke përdorur çelësin dhe algoritmin AES dhe në fund e shfaq rezultatin e tekstit të enkriptuar në ekran. Pas shfaqjes së këtij rezultati, shfrytëzuesit në ekran i shfaqet një mesazh nëse dëshiron për të shfaqur edhe tekstin e dekriptuar apo jo. Në rast se shfrytëzuesi e zgjedh edhe shfaqjen e tekstit të dekriptuar, programi bën dekriptimin e tekstit të enkriptuar duke përdorur të njëjtin çelës dhe algoritëm AES dhe shfaq tekstin e dekriptuar.

Krahas funksioneve për enkriptim dhe dekriptim të tekstit, kemi të implementuara edhe dy funksione të tjera rotXEncrypt dhe rotXDecrypt, të cilat e mundësojnë enkriptimin dhe dekriptimin e tekstit duke përdorur një rotacion të alfabetit të cilin e zgjedh shfrytëzuesi. Ky funksion implementohet duke u bazuar në llogaritjen e indeksit të shkronjës origjinale në alfabetin rotX dhe pastaj duke gjetur shkronjën e re duke llogaritur indeksin e ri në alfabetin rotX.

Shfrytëzuesi mund të zgjedhë një rotacion të caktuar për enkriptimin e tekstit dhe shfaqet në ekran enkriptimi i tekstit apo encrypted message përmes këtij rotacioni të cilin e ka zgjedhë shfrytëzuesi dhe dekripton tekstin përmes të njëjtit rotacion dhe poashtu e shfaq tekstin e dekriptuar në ekran.


