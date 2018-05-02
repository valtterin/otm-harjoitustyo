# K‰yttˆohje

Lataa tiedosto [muistipeli.jar](https://github.com/mluukkai/OtmTodoApp/releases/tag/0.1). Ohjelma k‰ynnistet‰‰n komennolla 

```
java -jar todoapp.jar
```

## Kuvaus

Ohjelma on peli, joka testaa pelaajan muistia. Perus-peliss‰ k‰ytt‰j‰lle n‰ytet‰‰n kuvio kerrallaan ketju kuvioita. K‰ytt‰j‰n n‰hty‰ symbolit, t‰m‰n tulee muistaa n‰kem‰ns‰ symbolit oikeassa j‰rjestyksess‰.

Pelaajan on mahdollista valita pelins‰ nelj‰st‰ eri pelimuodosta:

- Normal game
Kuvio-ketju koostuu nelj‰st‰ erityyppisest‰ kuviosta. Pelaajan muistettua kierroksen kuviot oikein, pelaajalle n‰ytet‰‰n t‰ysin uusi kuvio ketju, jonka pituus on edellist‰ yhdempi isompi.

- Easy game
Muuten kuin Normal game, paitsi muistettava kuvio-ketju s‰ilyy l‰pi kierrosten samana. Vain ketjun pituus kasvaa kunkin kierroksen p‰‰tteeksi yhdell‰!

- Blind game
Muuten kuin Easy game, paitsi k‰ytt‰j‰ n‰kee kunkin kierroksen alussa vain ketjun uusimman kuvion!

- Reverse game
Muuten kuin Normal game, paitsi k‰ytt‰j‰n tulee muistaa n‰kem‰ns‰ symbolit p‰invastaisessa j‰rjestyksess‰!