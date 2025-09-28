# Streameo - Application Android

Une application de streaming de films développée avec Jetpack Compose et suivant les bonnes pratiques d'architecture Android.

## 🏗️ Architecture

L'application suit une architecture propre et bien organisée :

```
app/src/main/java/com/example/streameo/
├── 📁 data/                    # Couche de données
│   ├── 📁 mock/               # Données fictives
│   ├── 📁 model/              # Modèles de données
│   └── 📁 repository/         # Repositories
├── 📁 navigation/             # Configuration de navigation
├── 📁 screens/               # Écrans de l'application
├── 📁 ui/                    # Composants UI
│   ├── 📁 components/
│   │   ├── 📁 common/        # Composants réutilisables
│   │   ├── 📁 home_components/ # Composants spécifiques à l'accueil
│   │   ├── 📁 movie/         # Composants liés aux films
│   │   └── 📁 navigation/    # Composants de navigation
│   └── 📁 theme/             # Thème et styles
├── 📁 utils/                 # Utilitaires et extensions
├── 📁 viewmodels/            # ViewModels
└── MainActivity.kt           # Activité principale
```

## 🗂️ Composants Principaux

### Navigation
- **NavigationDestinations.kt** : Définit toutes les destinations de navigation
- **StreameoNavigation.kt** : Configuration du graphe de navigation
- **NavigationUtils.kt** : Utilitaires pour la navigation

### Écrans
- **HomeScreen** : Écran d'accueil avec films tendances
- **BrowseScreen** : Écran de recherche et navigation par catégories
- **DetailScreen** : Écran de détails d'un film
- **ProfileScreen** : Écran de profil utilisateur

### Composants UI
- **common/** : Composants réutilisables (SectionTitle, BlurryIconButton)
- **movie/** : Composants spécifiques aux films (MovieCard)
- **home_components/** : Composants spécifiques à l'écran d'accueil
- **navigation/** : Composants de navigation (BottomNavBar)

### Data Layer
- **Movie** : Modèle de données pour les films
- **MovieRepository** : Repository pour la gestion des données de films
- **MockMovieData** : Données fictives pour le développement

### ViewModels
- **MovieViewModel** : Gestion de l'état des films et des interactions

## 🎨 Design System

L'application utilise un design system cohérent :

- **Colors** : Palette de couleurs sombres pour un look moderne
- **Typography** : Typographie Material Design 3
- **Components** : Composants réutilisables et consistants

## 🚀 Fonctionnalités

- ✅ Navigation fluide entre les écrans
- ✅ Affichage des films par catégories
- ✅ Écran de détail avec informations complètes
- ✅ Interface moderne et responsive
- ✅ Architecture maintenable et extensible

## 🛠️ Technologies Utilisées

- **Kotlin** : Langage principal
- **Jetpack Compose** : Framework UI moderne
- **Navigation Compose** : Navigation déclarative
- **Coroutines** : Gestion asynchrone
- **StateFlow** : Gestion d'état réactive
- **Coil** : Chargement d'images
- **Material Design 3** : Design system

## 📝 Notes de Développement

Cette refactorisation a permis :

1. **Séparation des responsabilités** : Chaque composant a un rôle clair
2. **Réutilisabilité** : Composants communs facilement réutilisables
3. **Maintenabilité** : Code organisé et facile à maintenir
4. **Extensibilité** : Architecture prête pour de nouvelles fonctionnalités
5. **Tests** : Structure facilitant l'écriture de tests

## 🔧 Build et Run

```bash
# Compiler le projet
./gradlew assembleDebug

# Lancer l'application
./gradlew installDebug
```
