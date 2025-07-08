# Exercice 4

## Partie 1

- En utilisant votre machine Windows, lancez le service Docker, s’il n’est pas lancé.

- Créer une image Docker sur votre machine du jeu 2048 (voir screen jeux_2048).

```bash
docker pull jgreat/2048
```

- Vérifier que l’image est bien présente sur votre machine.

```bash
docker images
```

- Lancer ce jeu sur un port disponible au travers d’un conteneur que vous allez appeler «jeu-votre-nom ». 

```bash
docker run -d -p 8081:80 --name 2048-noa-scelles jgreat/2048
```

- Vérifier que le conteneur est bien lancé avec la commande adaptée.

```bash
docker ps
```

- Créer un second conteneur qui va lancer le même jeu mais avec un nom différent «jeu2-votre-nom ».

```bash
docker run -d -p 8082:80 --name 20482-noa-scelles jgreat/2048
```

- Les 2 jeux sont fonctionnels en même temps sur votre machine, effectuez la commande pour vérifier la présence des conteneurs.

```bash
docker ps
```

- Ouvrez les 2 jeux sur votre navigateur. 

```
http://10.125.11.70:8081/
http://10.125.11.70:8082/
```

- Stopper les 2 conteneurs et assurez-vous que ces 2 conteneurs sont arrêtés.

```
docker stop 2048-noa-scelles
docker stop 20482-noa-scelles
docker ps
```

- Relancez le conteneur «jeu2-votre-nom » et aller vérifier dans votre navigateur s’il fonctionne bien. Effectuez la commande pour voir s’il a bien été relancé. Puis stopper le. 

```bash
docker start 20482-noa-scelles
docker ps
docker stop 20482-noa-scelles
```

- Supprimez l’image du jeu 2048 et les conteneurs associés.

```bash
docker rm 2048-noa-scelles
docker rm 20482-noa-scelles
docker rmi jgreat/2048
```

- Vérifiez que les suppressions ont bien été faite.

```bash
docker ps -a
docker images
```


## Partie 2


- Récupérer une image docker nginx.

```bash
docker pull nginx
```

- Créer un conteneur en vous basant sur cette image en lui attribuant le nom suivant : « nginx-web».
- Ce serveur nginx web (nginx-web) devra être lancé sur un port disponible.

```bash
docker run -d -p 8083:80 --name nginx-web nginx
```

- Assurez-vous que l’image est bien présente et que le conteneur est bien lancé.

```bash
docker ps
```

- Vérifier que le serveur est bien lancé au travers du navigateur.

- Une page web avec «Welcome to nignx » devrait s'afficher (voir nginx.png). 

- Effectuer la commande vous permettant de rentrer à l’intérieur de votre serveur nginx.

```bash
docker exec -it nginx-web bash
```

- Une fois à l’intérieur, aller modifier la page html par défaut de votre serveur nginx en changeant le titre de la page en :  
Welcome «votre prenom ».

```bash
apt update
apt install nano
nano /usr/share/nginx/html/index.html
```

- Relancez votre serveur et assurez-vous que le changement à bien été pris en compte, en relançant votre navigateur.

```bash
docker stop nginx-web
docker start nginx-web
```

- Refaite la même opération mais en utilisant le serveur web apache et donc il faudra créer un autre conteneur.

```bash
docker run -d -p 8084:80 --name apache-web httpd
--
docker exec -it apache-web bash
```

- Il faut supprimer le contenu complet de l'index.html et y mettre : "Je suis heureux et je m'appelle votre prenom".

```bash
apt update 
apt install nano
nano /usr/local/apache2/htdocs/index.html
```

- Le changement doit appaître dans votre navigateur.

```bash
docker stop apache-web
docker start apache-web
--
http://10.125.11.70:8084/
```

## Partie 3


- Répétez 3 fois la même opération que pour le début de la partie 2, il faudra juste appelez vos conteneurs :

- « nginx-web3 ».

```bash
docker run -d -p 8085:80 --name nginx-web3 nginx
```

- « nginx-web4 ».

```bash
docker run -d -p 8086:80 --name nginx-web4 nginx
```

- « nginx-web5 ».

```bash
docker run -d -p 8087:80 --name nginx-web5 nginx
```

- Il faudra faire en sorte que les pages html présente dans les fichiers ci-dessous s’affiche dans chacun des navigateurs en lien avec vos conteneurs :

- html5up-editorial-m2i.zip pour nginx-web3

```bash
docker cp '.\Documents\Formation\m2i-20250414-prf-java\17 - Docker\exercices\files_tp_conteneur\html5up-editorial-m2i.zip' nginx-web3:/html5up-editorial-m2i.zip
docker exec -it nginx-web3 bash
apt update
apt install unzip
unzip html5up-editorial-m2i.zip
mv html5up-editorial-m2i /usr/share/nginx
rm /usr/share/nginx/html/index.html
rmdir /usr/share/nginx/html

http://10.125.11.70:8085/
```

- html5up-massively.zip pour nginx-web4

```bash
docker cp '.\Documents\Formation\m2i-20250414-prf-java\17 - Docker\exercices\files_tp_conteneur\html5up-massively.zip' nginx-web4:/html5up-massively.zip
docker exec -it nginx-web4 bash

apt update
apt install unzip

mv html5up-massively.zip /usr/share/nginx/html
unzip html5up-massively.zip

http://10.125.11.70:8086/
```

- html5up-paradigm-shift.zip pour nginx-web5

```bash
docker cp '.\Documents\Formation\m2i-20250414-prf-java\17 - Docker\exercices\files_tp_conteneur\html5up-paradigm-shift.zip' nginx-web5:/html5up-paradigm-shift.zip
docker exec -it nginx-web5 bash

apt update
apt install unzip
apt install nano

mkdir html
mv html5up-paradigm-shift.zip html
unzip html/html5up-paradigm-shift.zip

nano /etc/nginx/conf.d/default.conf
-- On modifie la root par /html
service nginx restart
exit
docker start nginx-web5

http://10.125.11.70:8087/
```



- Stopper, ensuite, ces différents conteneurs.