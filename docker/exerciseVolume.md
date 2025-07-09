# Exercice — Migration d’un serveur web Dockerisé avec volume nommé

## Objectif

Mettre en place un site web statique à l’aide d’un serveur **Nginx**, en utilisant un **volume Docker nommé** pour stocker les fichiers du site.
Puis, après vérification du bon fonctionnement, migrer vers un serveur **Apache HTTPD** en réutilisant le même volume.

---

## Consignes

1. **Crée un volume Docker nommé** appelé `site_data`.

```bash
docker volume create site_data
```

2. **Prépare un site statique** local dans un dossier `site-web/` contenant au minimum un fichier `index.html` (par exemple avec le message : "Bienvenue sur notre site web").

```bash
mkdir site-web
echo "<h1>Mon site web</h1>" > index.html
```

3. **Copie les fichiers du site dans le volume nommé**, en utilisant un conteneur temporaire :

   * Le dossier local `site-web/` doit être copié dans le volume `site_data`.

   ```bash
   docker run -d -v site_data:/tmp nginx
   docker cp 'C:\Users\Administrateur\Desktop\Support de cours\m2iFormationJava\docker\site-web' bb05:/tmp
   ```

4. **Lance un conteneur Nginx** nommé `web-nginx` :

   * Il doit utiliser le volume `site_data` pour servir le site,
   * Il doit exposer un port (exemple accessible via `http://localhost:8080`),

   ```bash
   docker run -d -v site_data:/usr/share/nginx/html -p 8079:80 --name web-nginx nginx
   ```

5. **Vérifie dans le navigateur** que la page s’affiche correctement.

6. **Stoppe et supprime** le conteneur `web-nginx`.

```bash
docker stop web-nginx
docker rm web-nginx
```

7. **Lance un nouveau conteneur Apache HTTPD** nommé `web-apache` :

   * Il doit utiliser le **même volume nommé** `site_data`,
   * Il doit exposer le port 8080,
   * Le volume doit être monté à l’emplacement `/usr/local/apache2/htdocs/`.

    ```bash
   docker run -d -v site_data:/usr/local/apache2/htdocs/ -p 8078:80 --name web-apache httpd
   ```

8. **Vérifie que le site s’affiche toujours** correctement via `http://localhost:8080` si port 8080 utilisé.

 