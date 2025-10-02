# Chapitre 5 – Qualité et couverture des tests  
## Exercice pratique : Mesurer et améliorer la couverture avec JaCoCo

### Étape 1 – Préparer le projet

- Réutilisez vos classes précédentes (`Calculator`, `ApiClient`, `ApiService`) et leurs tests.  
- Ajoutez JaCoCo à votre projet (via votre IDE ou un jar standalone).  
- Configurez l’exécution des tests pour générer un rapport de couverture.  

---

### Étape 2 – Générer un premier rapport

- Exécutez vos tests existants avec JaCoCo.  
- Ouvrez le rapport HTML généré.  
- Identifiez les classes ou méthodes **non couvertes** ou **partiellement couvertes** (par exemple `power` de `Calculator`, ou `hasData` de `ApiService`).  

---

### Étape 3 – Ajouter des tests pour augmenter la couverture

Vérifiez que le code coverage est à 100%, si ce n'est pas le cas, ajoutez des tests

### Étape 5 – Suivi et amélioration continue

- Cherchez comment forcer le code coverage à 80% minimum dans le fichier pom.xml
- Explorez la documentation, cherchez à ajouter des vérifications / autre si vous le jugez nécessaire

---