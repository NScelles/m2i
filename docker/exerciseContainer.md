**Exercice : Manipulation de Docker avec une image Alpine et GitHub**

**Objectif :**
Ce exercice vise à évaluer votre compréhension et votre maîtrise des commandes de base de Docker, en particulier sur l'utilisation d'une image Alpine, la récupération d'un dépôt public depuis GitHub, la modification des fichiers dans le container et la copie des résultats sur la machine locale.

**Sujet :**

1. **Prérequis :**

   - Assurez-vous d'avoir Docker installé sur votre machine.
   - Ouvrez un terminal.

   ```bash
   OUI !
   ```

2. **Création d'un container Alpine :**

   - Utilisez la commande Docker pour créer un container basé sur l'image Alpine.
   - Connectez-vous au shell du container nouvellement créé.

   ```bash
   docker search alpine
   --
   docker run -it -p 8080:80 --name curious-platon alpine
   ```

3. **Récupération d'un dépôt GitHub :**

   - À l'intérieur du container, utilisez la commande `git` pour cloner un dépôt public depuis GitHub (par exemple, https://github.com/votre-utilisateur/exemple-repo.git).
   - Allez dans le répertoire du dépôt cloné.

   ```bash
   apk add git
   --
   git clone https://github.com/NScelles/m2i.git
   --
   cd m2i
   ```

4. **Modification du contenu :**
   - À l'intérieur du container, ouvrez un fichier texte (par exemple, README.md) à l'aide d'un éditeur de texte disponible dans l'image Alpine.
   - Ajoutez une ligne de texte à votre choix et enregistrez le fichier.

   ```bash
   apk add nano
   nano exerciseContainer.md
   --
   git config --global core.editor "nano"
   git config --global user.email n.scelles974@gmail.com
   -- Écriture du texte que tu es entrain de lire
   git add .
   git commit -a
   git push
   ```
   

**infos**:
Alpine est une version de Linux qui présente des variations dans les commandes par rapport à Ubuntu.
pour remplacer apt-get -> apk
pour remplacer apt-get install -> apk add
 