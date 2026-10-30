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
                    ProfileMainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// 1. Écran principal
@Composable
fun ProfileMainScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        DeveloperProfileCard(
            name = "Thomas Bernard",
            role = "Développeur Android junior",
            description = "Je cherche un stage pour progresser en Kotlin, Compose et développement mobile Android.",
            skills = listOf("• Kotlin", "• Compose", "• Git", "• Android Studio"),
            contact = "Contact : thomas.bernard@example.com",
            availability = "Disponible pour un stage",
            actionText = "Contacter",
            onCardClick = {},
            onActionClick = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}

// 2. La carte de profil globale
@Composable
fun DeveloperProfileCard(
    name: String,
    role: String,
    description: String,
    skills: List<String>,
    contact: String,
    availability: String,
    actionText: String,
    onCardClick: () -> Unit,
    onActionClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .clickable(
                role = Role.Button,
                onClick = onCardClick
            )
            .semantics {
                contentDescription = "Profil de $name, $role"
            },
        shadowElevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp) // Padding interne de la carte
        ) {
            ProfileHeader(
                name = name,
                role = role,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            ProfileDescription(
                text = description,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            ProfileSkillsSection(
                skills = skills,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            ProfileContactInfo(
                contact = contact,
                modifier = Modifier.padding(bottom = 12.dp)
            )
            ProfileAvailabilityBox(
                availability = availability,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            ProfileActionButton(
                text = actionText,
                onClick = onActionClick,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

// 3. Composables unitaires réutilisables
@Composable
fun ProfileHeader(name: String, role: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = name)
        Text(text = role)
    }
}

@Composable
fun ProfileDescription(text: String, modifier: Modifier = Modifier) {
    Text(text = text, modifier = modifier)
}

@Composable
fun ProfileSkillsSection(skills: List<String>, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "Compétences")
        for (skill in skills) {
            Text(text = skill)
        }
    }
}

@Composable
fun ProfileContactInfo(contact: String, modifier: Modifier = Modifier) {
    Text(text = contact, modifier = modifier)
}

@Composable
fun ProfileAvailabilityBox(availability: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = availability,
            modifier = Modifier.padding(12.dp)
        )
    }
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

// 4. Previews
@Preview(name = "AndroidJuniorProfilePreview", showBackground = true)
@Composable
fun AndroidJuniorProfilePreview() {
    ProfilDeveloppeurComposeTheme {
        Surface(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            DeveloperProfileCard(
                name = "Romain Berry",
                role = "Développeur Android junior",
                description = "Je cherche un stage pour progresser en Kotlin, Compose et développement mobile Android.",
                skills = listOf("• Kotlin", "• Compose", "• Git", "• Android Studio"),
                contact = "Contact : romain.berry@example.com",
                availability = "Disponible pour un stage",
                actionText = "Contacter",
                onCardClick = {},
                onActionClick = {},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(name = "FullStackProfilePreview", showBackground = true)
@Composable
fun FullStackProfilePreview() {
    ProfilDeveloppeurComposeTheme {
        Surface(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            DeveloperProfileCard(
                name = "Camille Leroy",
                role = "Développeuse full-stack",
                description = "Développeuse polyvalente, je travaille sur des applications web et mobiles avec une attention particulière à la qualité du code.",
                skills = listOf("• Kotlin", "• JavaScript", "• Backend", "• Git"),
                contact = "Contact : camille.leroy@example.com",
                availability = "Disponible en freelance",
                actionText = "Voir le portfolio",
                onCardClick = {},
                onActionClick = {},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}