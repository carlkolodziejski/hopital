# Idées, choses à retenir

## RendezVous

- Faire en sorte que le feedback et le diagnostic ne puissent être donnés qu'après le rdv en comparant la date du rdv
  avec LocalDate.now().

## Facture

- Facture.detail = RendezVous.toString() ?
- Facture.coutTotal = nombre de rdv dans la facture * prix d'un rdv ?
- Ça serait une DINGUERIE de générer un pdf pour afficher la facture !1!1!1!11!1!1
- Si une facture est payée, les nouveaux rendez-vous sont ajoutés à une nouvelle facture.

## Controleur

- Remplacer tous les menus présents dans la classe Hopital par des scenes.

## HistoriqueMedical

- HistoriqueMedical.historiqueRendezVous sera une pile.

## Menus

Espace patient :

- D'abord demander de quel patient il s'agit
- Prendre rendez-vous
- Régler facture -> uniquement possible après un rendez-vous
- Consulter historique médical
- Donner un avis -> uniquement possible après un rendez-vous et par la personne concernée
-

Espace médecin :
  