⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⢠⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
⢠⣴⣾⢿⣷⣦⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⡇⠀⢀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠀⠀⠀⠀
⠸⣿⠀⠀⠈⢻⣷⠰⠇⠀⠀⠀⠀⠀⣷⠀⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⠹⣧⠀⣾⢻⡄⠀⢀⣀⡀⢰⣤⢦⡄⢀⡇⠀⠀⢸⡇⠀⠀⠀
⠀⢿⣇⠀⢀⣾⠇⠀⡆⠀⢀⡶⠒⢸⣿⡴⠏⠀⠀⠀⢠⡄⠀⢀⠀⣾⠀⠀⠀⣿⠀⢹⢰⡿⢰⣧⢠⡞⢻⡇⢸⣧⠞⢁⣼⣥⣀⠀⠈⣷⣀⡤⠖
⠀⠈⣿⣿⣿⣁⠀⠀⢻⠀⣿⠀⠀⠀⣿⢧⡀⠀⠀⠀⡿⢧⠿⢾⣴⣇⠀⠀⢸⡟⠀⠘⢿⠁⠈⡟⠸⢧⣼⠟⢠⠉⢷⠀⢸⠀⠀⢀⣰⡿⠋⠀⠀
⠀⠀⢻⡆⠈⠛⢻⣆⠘⠀⠙⠏⠉⠀⠇⠈⢿⡄⠀⠀⠁⠈⠀⠀⠈⠉⠀⠀⢘⠃⠀⠀⠀⠀⠀⢿⠀⠀⠀⠀⠀⠀⠸⠀⡼⠀⢀⡾⠋⠀⠀⠀⠀
⠀⠀⠘⣧⠀⠀⠀⠈⠳⡄⠀⠀⠀⠀⠀⠀⠈⠓⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠀⠀⠀⠀⠀⠀⠘⠇⠀⠀⠀⠀⠀⠀⠀⢀⡴⠋⠀⠀⠀⠀⠀⠀
⠀⠀⠀⠙⠀⠀⠀⠀⠀⠙⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀⠀⠀⠀⠀

# Rick and Morty API - Kotlin Multiplatform Project (KMP)

Ce projet est une implémentation d'une application Kotlin qui utilise l'API de Rick and Morty pour obtenir des informations sur les personnages, épisodes et lieux. Ce projet utilise **Kotlin Multiplatform (KMP)** et suit les principes de **Clean Architecture**, **MVI (Model-View-Intent)** et **UDF (Unidirectional Data Flow)** pour une gestion claire et réactive de l'état et des données.

## Architecture du projet

### Structure générale du projet

Le projet suit une architecture **Kotlin Multiplatform (KMP)**, permettant de partager la logique métier entre Android, iOS et d'autres plateformes tout en respectant les principes de **Clean Architecture** et de **MVI (Model-View-Intent)**.

#### **Android (androidApp)**

Le module **androidApp** contient tout le code spécifique à la plateforme Android. Cela inclut les composants d'interface utilisateur (UI) comme les `Activity`, `Fragment`, et `ViewModel` qui sont utilisés pour interagir avec les utilisateurs sur Android.

#### **Desktop (desktopApp)**

Le module **desktopApp** contient tout le code spécifique à la plateforme Desktop, y compris l'interface utilisateur et les fonctionnalités spécifiques au bureau.

#### **Shared (shared)**

Le module **shared** contient la logique métier partagée entre les différentes plateformes (Android, Desktop, iOS). Il inclut les entités, les cas d'utilisation, les repositories, et toute la logique réutilisable.


### 1. **Layered Architecture**

L'application Android est organisée selon plusieurs couches :

- **Domain Layer** : C'est la couche centrale de l'architecture. Elle contient les entités du domaine (modèles métier) et la logique métier principale. Elle est totalement du reste.
- **Data Layer** : Cette couche est responsable de la récupération et du stockage des données, qu'elles proviennent d'une API REST, d'une base de données locale ou d'une autre source de données. Elle interagit avec les services externes comme l'API de Rick and Morty.
- **UI Layer** : C'est la couche qui contient les composants de l'interface utilisateur (UI), tels que les `Composbales`, `Screen`, ou `ViewModel`. Elle interagit avec les `ViewModels` pour observer les données et mettre à jour l'UI.
  
### 2. **Couches détaillées de l'architecture**

#### **Domain Layer**
Cette couche contient les cas d'utilisation (Use Cases) et les entités métiers. Elle définit les règles de traitement de données sans dépendre des technologies spécifiques comme les API ou les frameworks.

- **Entities** : Ce sont des objets de données représentant les modèles métier, tels que `Character`, `Episode`, et `Location`.
- **Use Cases** : Ce sont des cas d'utilisation qui définissent les opérations métier, comme la récupération des personnages de Rick and Morty, l'ajout de nouveaux éléments, etc.

#### **Data Layer**
Cette couche est responsable de la gestion de la récupération et du stockage des données, en se connectant à des sources de données comme une API distante.

- **Repositories** : Les repositories sont responsables de la gestion des données. Ils récupèrent les données des sources appropriées (API, cache, base de données locale) et les fournissent aux cas d'utilisation de la couche Domaine.
- **Data Sources** : Ce sont des implémentations spécifiques qui récupèrent les données depuis des sources externes, comme une API REST ou une base de données locale.

#### **Presentation Layer**
Cette couche gère l'interface utilisateur et interagit avec le `ViewModel`, qui est responsable de la gestion de l'état de l'application.

- **ViewModel** : Le `ViewModel` récupère les données via les `Use Cases` et expose les résultats à l'UI sous forme d'observables (LiveData ou StateFlow). Il gère également la logique de l'interface utilisateur.
- **UI Components** : Les `Screen` sont responsables de la gestion des vues. Ils interagissent avec le `ViewModel` et réagissent aux changements d'état pour mettre à jour l'interface.

### 3. **Principes de Clean Architecture appliqués**

Le projet respecte les principes de Clean Architecture en garantissant une séparation claire des responsabilités, ce qui permet :

- **Indépendance des frameworks** : La logique métier est totalement découplée des technologies spécifiques comme Android ou les API tierces.
- **Testabilité** : Chaque couche peut être testée indépendamment. Par exemple, la logique métier peut être testée sans avoir besoin de simuler une interface utilisateur Android.
- **Indépendance des UI** : La présentation est totalement séparée de la logique métier, ce qui facilite la modification de l'interface utilisateur sans affecter les autres parties du code.

### 4. **Communication entre les couches**

- La couche **présentation** (UI) communique avec la couche **domaine** via des `ViewModel`.
- Les `Use Cases` dans la couche **domaine** appellent les `Repositories` de la couche **données** pour récupérer ou manipuler des données.
- Les `Repositories` communiquent avec les **Data Sources** pour accéder aux sources externes de données (API, base de données locale, etc.).

### 5. **Exemples de flux de données**

1. **Récupérer les personnages** : L'utilisateur ouvre la page des personnages.
    - L'UI demande au `ViewModel` de récupérer les personnages.
    - Le `ViewModel` appelle le cas d'utilisation dans la couche **domaine**.
    - Le cas d'utilisation demande au `Repository` de récupérer les données via l'API.
    - Le `Repository` fait appel à l'API et retourne la réponse.
    - Le cas d'utilisation traite les données et les retourne au `ViewModel`.
    - Le `ViewModel` expose les données via un flux observable (LiveData ou StateFlow).
    - L'UI observe les données et les met à jour.

2. **Ajouter un nouveau personnage** : L'utilisateur soumet un formulaire pour ajouter un personnage.
    - L'UI appelle le `ViewModel` pour envoyer les nouvelles informations.
    - Le `ViewModel` appelle le cas d'utilisation pour ajouter le personnage.
    - Le cas d'utilisation appelle le `Repository` pour stocker les données.
    - Le `Repository` effectue la requête API pour ajouter le personnage et retourne la confirmation.
    - Le `ViewModel` met à jour l'UI pour indiquer le succès de l'opération.

### 6. **Technologies utilisées**

- **Kotlin Multiplatform (KMP)** : Permet de partager la logique métier entre Android, iOS, et d'autres plateformes.
- **Retrofit** : Utilisé pour effectuer des requêtes HTTP vers l'API Rick and Morty.
- **Coroutines et Flow** : Pour la gestion asynchrone des tâches.
- **Room** : pour la gestion de la base de données locale.
- **Jetpack Compose** : Pour la gestion de l'interface utilisateur moderne.
- **Koin** : Framework d'injection de dépendances léger et simple utilisé pour gérer les dépendances entre les différentes couches de l'application.
- **Gradle** : Utilisé comme système de gestion de build pour la gestion des dépendances, des plugins et des configurations de projet.

### 1. **Android (androidApp)**

Le module **androidApp** contient tout le code spécifique à la plateforme Android. Cela inclut les composants d'interface utilisateur (UI) comme les `Activity`, `Fragment`, et `ViewModel` qui sont utilisés pour interagir avec les utilisateurs sur Android.

### 2. **Desktop (desktopApp)**

Le module **desktopApp** contient tout le code spécifique à la plateforme Desktop, y compris l'interface utilisateur et les fonctionnalités spécifiques au bureau.

### 3. **Shared (shared)**

Le module **shared** contient la logique métier partagée entre les différentes plateformes (Android, Desktop, iOS). Il inclut les entités, les cas d'utilisation, les repositories, et toute la logique réutilisable.

---

## Architecture et Flux de Données

### **Pattern Unidirectional Data Flow (UDF)**

Le projet utilise le pattern **UDF (Unidirectional Data Flow)** pour gérer les flux de données entre la vue et la logique métier. Cela garantit que les données circulent dans une direction unidirectionnelle, ce qui rend le flux de l'application prévisible et facile à déboguer.

#### **Les composants UDF** :

- **State** : Le `State` représente l'état actuel de l'interface utilisateur (UI). Ce modèle d'état est encapsulé dans un objet immuable (`UiState`) qui est mis à jour chaque fois que des changements doivent être reflétés dans l'UI. Il contient généralement des informations comme les résultats des appels API, les erreurs et d'autres informations contextuelles nécessaires à l'affichage de l'interface.
  
- **Action** : Les **Actions** sont des événements générés par l'utilisateur, comme un clic sur un bouton ou un changement de sélection dans une liste. Ces actions sont envoyées au **ViewModel** pour être traitées. Les actions peuvent être définies sous forme de classes ou d'enumérations.

- **ViewModel** : Le **ViewModel** agit comme un contrôleur central pour gérer l'état et les actions. Il reçoit les **Actions**, modifie le **State** en fonction de la logique métier, et expose le nouvel **UiState** à la **View** (via un `StateFlow` ou `LiveData`). C’est un intermédiaire entre la vue et la logique métier, et il est conçu pour être découplé des composants d'UI.

- **Navigator** : Le **Navigator** est responsable de la navigation dans l’application. Il permet de gérer la navigation entre les écrans en réponse à des actions. Par exemple, après que l'utilisateur ait cliqué sur un élément de la liste, le **Navigator** déclenchera la navigation vers un autre écran pour afficher les détails.

### **Interaction avec Jetpack Compose**

**Jetpack Compose** est utilisé pour construire l'UI de manière déclarative. L'UI réagit au changement d'état en observant les flux d'état (comme `StateFlow` ou `LiveData`) exposés par le **ViewModel**.

Dans cette architecture **UDF**, l'interface est directement liée à l'état via des **Composables**. Par exemple :

```kotlin
@Composable
fun CharacterListScreen(viewModel: CharacterViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    when (val state = uiState) {
        is UiState.Loading -> {
            // Afficher un indicateur de chargement
        }
        is UiState.Success -> {
            // Afficher la liste des personnages
        }
        is UiState.Error -> {
            // Afficher une erreur
        }
    }
}