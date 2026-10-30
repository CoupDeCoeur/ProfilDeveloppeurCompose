# Profil Développeur Compose - BERRY Romain 

## Description courte
Application Android développée avec Jetpack Compose représentant une fiche de profil développeur interactive et modulaire. Elle présente les informations professionnelles, le statut de disponibilité et propose une action de contact.

## Notions utilisées
- Paramètres de réutilisabilité
- Modifiers et chaînage de modifiers
- Padding externe et padding interne
- Callbacks d'événements utilisateur
- Previews multiples

## Réponses aux questions du devoir
1. **Quels composables avez-vous créés ?**
   J'ai créé `ProfileDemoScreen`, `DeveloperProfileCard`, `ProfileHeader`, `ProfileDescription`, `ProfileAvailability` et `ProfileActionButton`.
2. **Quel composable représente l'écran principal ?**
   C'est le composable `ProfileDemoScreen`.
3. **Où utilisez-vous un padding externe ?**
   Il est appliqué au niveau de l'écran principal (`ProfileDemoScreen`) pour espacer la carte des bords de l'appareil.
4. **Où utilisez-vous un padding interne ?**
   Il est appliqué à l'intérieur de la carte (`DeveloperProfileCard`) pour structurer et espacer les textes et boutons par rapport aux bords de la surface.
5. **Quel composant reçoit un callback ?**
   Les composants interactifs comme `DeveloperProfileCard` et `ProfileActionButton` reçoivent des callbacks (`onProfileClick`, `onContactClick`).
6. **Quelle information d'accessibilité avez-vous ajoutée ?**
   J'ai utilisé `.clickable(role = Role.Button, ...)` et `.semantics { contentDescription = "Ouvrir le profil de..." }` sur la carte interactive.
7. **Pourquoi vos composants peuvent-ils être considérés comme réutilisables ?**
   Parce qu'ils acceptent des paramètres de données (`name`, `roleTitle`, etc.) ainsi qu'un `modifier: Modifier = Modifier`, ce qui leur permet d'être affichés avec différents jeux de données et dans divers contextes.

## Capture d'écran
Lien vers la capture d'écran : "https://ibb.co/JRm49jbJ"