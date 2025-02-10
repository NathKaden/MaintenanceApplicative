# MaintenanceApplicative
### [R6.A.06] Maintenance applicative (2025)

## r6a06_refactorisation_dirigee
TP de refactorisation de code

On a trois classes : 
customer, rental et movie

Dans la méthode Customer::statement, la portion de code du while indiquée par des flèches indique un switch : 
    Ce switch/case indique si le prix du film est normal, nouveau ou childrens
Une fois la méthode extraite, on enlève les paramètres inutiles, et on initialise cette variable locale dans la méthode.