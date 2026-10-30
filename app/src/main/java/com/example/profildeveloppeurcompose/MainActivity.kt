package com.example.profildeveloppeurcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profildeveloppeurcompose.ui.theme.ProfilDeveloppeurComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProfilDeveloppeurComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProfileDemoScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

//Écran principal
@Composable
fun ProfileDemoScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        DeveloperProfileCard(
            name = "Berry Romain",
            roleTitle = "Développeur Android Compose",
            availability = "Disponible pour un stage",
            isAvailable = true,
            onProfileClick = {
                // Action vide
            },
            onContactClick = {
                // Action de contact vide
            },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

//La carte de profil globale
@Composable
fun DeveloperProfileCard(
    name: String,
    roleTitle: String,
    availability: String,
    isAvailable: Boolean,
    onProfileClick: () -> Unit,
    onContactClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .clickable(
                role = Role.Button,
                onClick = onProfileClick
            )
            .semantics {
                contentDescription = "Ouvrir le profil de $name"
            },
        shadowElevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp) // Padding interne de la carte
        ) {
            ProfileHeader(
                name = name,
                roleTitle = roleTitle,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            ProfileDescription(
                text = "Étudiant en informatique qui aime le développement mobile natif et Jetpack Compose.",
                modifier = Modifier.padding(bottom = 8.dp)
            )
            ProfileAvailability(
                availability = availability,
                isAvailable = isAvailable,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            ProfileActionButton(
                text = "Contacter le développeur",
                onClick = onContactClick,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

//Composables unitaires réutilisables
@Composable
fun ProfileHeader(name: String, roleTitle: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = name)
        Text(text = roleTitle)
    }
}

@Composable
fun ProfileDescription(text: String, modifier: Modifier = Modifier) {
    Text(text = text, modifier = modifier)
}

@Composable
fun ProfileAvailability(availability: String, isAvailable: Boolean, modifier: Modifier = Modifier) {
    val statusText = if (isAvailable) "Statut : $availability" else "Statut : Non disponible"
    Text(text = statusText, modifier = modifier)
}

@Composable
fun ProfileActionButton(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(text = text)
    }
}

//Previews
@Preview(showBackground = true)
@Composable
fun ProfileAvailablePreview() {
    ProfilDeveloppeurComposeTheme {
        ProfileDemoScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileUnavailablePreview() {
    ProfilDeveloppeurComposeTheme {
        Surface(modifier = Modifier.fillMaxSize().padding(24.dp)) {
            DeveloperProfileCard(
                name = "Julie Dupont",
                roleTitle = "Développeuse Full-Stack",
                availability = "En poste",
                isAvailable = false,
                onProfileClick = {},
                onContactClick = {},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}