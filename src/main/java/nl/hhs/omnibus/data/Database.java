package nl.hhs.omnibus.data;

import nl.hhs.omnibus.common.Constants;
import nl.hhs.omnibus.models.Identifiable;
import nl.hhs.omnibus.models.Nameable;
import nl.hhs.omnibus.models.gadgets.Base;
import nl.hhs.omnibus.models.gadgets.Gadget;
import nl.hhs.omnibus.models.gadgets.Vehicle;
import nl.hhs.omnibus.models.gadgets.Weapon;
import nl.hhs.omnibus.models.navigation.ListableMenuItem;
import nl.hhs.omnibus.models.navigation.Menu;
import nl.hhs.omnibus.models.navigation.NavigableMenuItem;
import nl.hhs.omnibus.models.persons.Fan;
import nl.hhs.omnibus.models.persons.Hero;
import nl.hhs.omnibus.models.persons.Villain;
import nl.hhs.omnibus.models.teams.HeroTeam;
import nl.hhs.omnibus.models.teams.VillainTeam;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Database {
    private List<Gadget> gadgets;
    private List<Fan> fans;
    private List<Hero> heroes;
    private List<HeroTeam> heroicTeams;
    private List<Villain> villains;
    private List<VillainTeam> villainousTeams;

    private Menu menuMain;

    public Database() {
        this.initializeData();
        this.initializeMenus();
    }

    private void initializeData() {
        // Fans
        Fan oscarWellner = new Fan("Oscar Wellner");
        Fan eleonoraAvaleva = new Fan("Eleonora Avaleva");
        Fan jordyHuizer = new Fan("Jordy Huizer");
        Fan milevaMaric = new Fan("Mileva Maric");
        Fan maryCurieary = new Fan("Mary Curie");
        Fan rogerPenrose = new Fan("Roger Penrose");
        Fan jamesGosling = new Fan("James Gosling");
        Fan joseSaramago = new Fan("Jose Saramago");
        Fan titosPullo = new Fan("Titos Pullo");
        Fan guidoVanRossum = new Fan("Guido van Rossum");
        Fan dennisRitchie = new Fan("Dennis Ritchie");
        Fan adaLovelace = new Fan("Ada Lovelace");
        Fan albertCamus = new Fan("Albert Camus");
        Fan aldusHuxley = new Fan("Aldus Huxley");

        this.fans = Arrays.asList(
            oscarWellner,
            eleonoraAvaleva,
            jordyHuizer,
            milevaMaric,
            maryCurieary,
            rogerPenrose,
            jamesGosling,
            joseSaramago,
            titosPullo,
            guidoVanRossum,
            dennisRitchie,
            adaLovelace,
            albertCamus,
            aldusHuxley
        );

        // Heroes
        Hero batman = new Hero("Batman", "Gotham City", 50, "Bruce Wayne", "The bat is here!!");
        Hero catwoman = new Hero("Catwoman", "Gotham City", 37, "Selina Kyle", "I like weapons that only the skilled can control… Guns are for jerks and cowards.");
        Hero blackWidow = new Hero("Black Widow", "Norway", 35, "Natalia Alianovna Romanova", "I’m sorry, did I step on your moment?");
        Hero wolverine = new Hero("Wolverine", "Alberta", 25, "James Howlett", "Meet my claws!");
        Hero ironMan = new Hero("Iron man", "Long Island", 26, "Tony Stark", "The Truth is… I am Iron Man.");
        Hero thor = new Hero("Thor", "Asgardian", 26, "Thor Borson", "You have no idea what you are dealing with.");
        Hero hulk = new Hero("Hulk", "Sakaaran", 50, "Robert Bruce Banner", "Hulk will break metal man open like a tin can. Metal man thinks he is stronger than Hulk. Metalman wrong");
        Hero spiderman = new Hero("Spiderman", "New York", 14, "Peter Parker", "With great power, comes great responsibility");

        this.heroes = Arrays.asList(batman, catwoman, blackWidow, wolverine, ironMan, thor, hulk, spiderman);

        // Teams of Heroes
        HeroTeam theAvengers = new HeroTeam("The Avengers");
        HeroTeam theFantasticFour = new HeroTeam("The Fantastic Four");

        this.heroicTeams = Arrays.asList(theAvengers, theFantasticFour);

        // Villains
        Villain joker = new Villain("Joker", "Gotham City", 49, "Selling Smylex", "If you're good at something, never do it for free");
        Villain mrFreeze = new Villain("Mr. Freeze", "Gotham City", 19, "destroy everything Batman loves");
        Villain lokiLaufeyson = new Villain("Loki Laufeyson", "Asgard", 27, "take over the planet");
        Villain abomination = new Villain("The Abomination", "Harlem", 50, "Kill the Hulk! Gain more power in order to be able to become the most powerful warrior on Earth by killing everyone who stands in his way.");
        Villain viper = new Villain("Viper", "None", 35, "");
        Villain ladyDeathstrike = new Villain("Lady Deathstrike", "location", 30, "");
        Villain venom = new Villain("Venom", "New York", 55, "");
        Villain greenGoblin = new Villain("Green Goblin", "New York", 25, "To gain full control over Spiderman's mind.");

        this.villains = Arrays.asList(joker, mrFreeze, lokiLaufeyson, abomination, viper, ladyDeathstrike, venom, greenGoblin);

        // Teams of Villains
        VillainTeam theThunderbolts = new VillainTeam("The Thunderbolts");
        VillainTeam theSinisterSix = new VillainTeam("The Sinister Six");

        this.villainousTeams = Arrays.asList(theThunderbolts, theSinisterSix);

        // Gadgets
        Base batcave = new Base("Batcave", "Batman's cave", batman, "Gotham City");
        Base underwaterBase = new Base("Underwater base", "A well designed underwater base", thor, "Under the see");
        Base jokersFunHouse = new Base("Joker's Funhouse", "Is located at the center of Amusement Mile in Otisburg district", joker, "Gotham City");
        Base lokiPalace = new Base("Loki Palace", "It is an underground palace hideout located in the Void.", lokiLaufeyson, "Unknown");
        Base bannerB773hideout = new Base("Banner Hideout B-733", "An underground grotto located beneath a " + "lake in the Chihuahuan Desert", hulk, "New Mexico");
        Vehicle batmobile = new Vehicle("Batmobile", "Batman's supercar", batman, "380 km/h", 1);
        Vehicle blackWidowMotor = new Vehicle("Black Widow's Motorcycle", "Fast Harley-Davidson bike", blackWidow, "350 km/h", 2);
        Vehicle dodgeViper = new Vehicle("Dodge Viper", "Fast car", viper, "480 km/h", 2);
        Vehicle zephyrOne = new Vehicle("Zephyr One", "Is a mobile airborne command plane", hulk, "1875 km/h", 30);
        Vehicle f22Raptor = new Vehicle("F-22 Raptor", "A single-seat, twin-engine fifth-generation super maneuverable fighter aircraft that uses stealth technology.", ironMan, "1845 km/h", 1);
        Weapon rocketPropelledGrenade = new Weapon("Rocket propelled grenade", "Click, BOOM!", batman, 75);
        Weapon batarang = new Weapon("Batarang", "Batman's boomerang", batman, 35);
        Weapon whip = new Weapon("Whip", "Uses her whip to attack in combat, and to trip up enemies. ", catwoman, 0);
        Weapon caltrop = new Weapon("Caltrop", "A sharp, metal jacks that could be dropped and used as a trap. Enemies trip and fall down when they step on them.", catwoman, 0);
        Weapon teaserDisks = new Weapon("Teaser Disks", "Teaser disks are an extension of her widow bites, and these disks can electrocute a person without needing to make contact with them.", blackWidow, 0);
        Weapon dualBatons = new Weapon("Dual Batons", "Similar to her widow bites, Natasha's dual batons are electrically charged, where she is able to electrocute the Ultron bots, taking them offline after only a few precise blows.", blackWidow, 0);
        Weapon adamantiumClaws = new Weapon("adamantium claws ", "His Claws Are Fused With Adamantium (a rare metal).", wolverine, 0);
        Weapon healingPowers = new Weapon("healing powers", "The ability to heal others ", wolverine, 0);
        Weapon flameThrower = new Weapon("Flame thrower", "Create one hot enough and it could have melted some Ultron robots. ", ironMan, 0);
        Weapon missiles = new Weapon("Missiles", "To kit out his suits with enough firepower to take down a tank or even a bunker", ironMan, 0);
        Weapon jarnbjorn = new Weapon("Jarnbjorn", "The Battle Axe", thor, 0);
        Weapon ultimateMjolnir = new Weapon("Ultimate Mjolnir", "the mystical Uru Warhammer.", thor, 0);
        Weapon utilityBelt = new Weapon("Utility Belt", "A belt", spiderman, 0);
        Weapon acidFlower = new Weapon("Acid Flower", "Acidic flowers, that kill everyone who touches them. ", joker, 0);
        Weapon razorCards = new Weapon("Razor cards", "Sharp razor cards", joker, 0);
        Weapon iceGun = new Weapon("Ice Gun", "Also known simply as the 'Cold Gun' and 'Freeze Ray', is a piece of cryogenics weaponry which serves as Mister Freeze's signature weapon.", mrFreeze, 0);
        Weapon magicSword = new Weapon("Magic sword", "A magic sword, known in Norse mythology as Laevateinn, which means \"wounding wand\".", lokiLaufeyson, 0);
        Weapon cyberpathy = new Weapon("Cyberpathy", "Deathstrike is able to cybernetically interface her consciousness with external computer systems, " + "allowing for direct data access to her brain's memory centers and granting her the ability to remotely operate digital & computerized systems.", ladyDeathstrike, 0);
        Weapon weaponV = new Weapon("Weapon V ", "In addition to wielding military ordinance, Weapon V operatives can use their symbiotes to manifest claws, fangs, spikes, tendrils, and blades.", venom, 0);
        Weapon pumpkinBombs = new Weapon("Pumpkin Bombs", "Osborn uses these specialized bombs to blow up or disintegrate his targets.", greenGoblin, 0);
        Weapon razorBats = new Weapon("Razor Bats", "Osborn uses these drones to slice his enemies.", greenGoblin, 0);

        this.gadgets = Arrays.asList(
            batcave,
            underwaterBase,
            jokersFunHouse,
            lokiPalace,
            bannerB773hideout,
            batmobile,
            blackWidowMotor,
            dodgeViper,
            zephyrOne,
            f22Raptor,
            rocketPropelledGrenade,
            batarang,
            whip,
            caltrop,
            teaserDisks,
            dualBatons,
            adamantiumClaws,
            healingPowers,
            flameThrower,
            missiles,
            jarnbjorn,
            ultimateMjolnir,
            utilityBelt,
            acidFlower,
            razorCards,
            iceGun,
            magicSword,
            cyberpathy,
            weaponV,
            pumpkinBombs,
            razorBats
        );

        // TODO - Link rivalry between Heroes and Villains

        // TODO - Setup Favorite Characters of Fans
    }

    private void initializeMenus() {
        // Combine the Hero- and Villain Teams into one list
        // for listing the various teams under MenuItem for Teams
        // Sorted by the item's ID.
        List<Nameable> teams = Stream.of(this.heroicTeams, this.villainousTeams)
            .flatMap(Collection::stream)
            .sorted(Identifiable::compareTo)
            .collect(Collectors.toList());

        // Combine Heroes, Villains, Fans, and Teams lists into one list
        // for searching for a person or team.
        // Sorted by the item's ID.
        List<Nameable> peopleAndTeams = Stream.of(this.heroes, this.villains, this.fans, teams)
            .flatMap(Collection::stream)
            .sorted(Identifiable::compareTo)
            .collect(Collectors.toList());

        // Menus
        this.menuMain = new Menu("Main Menu");
        Menu menuPeople = new Menu("People Menu");
        Menu menuGadgets = new Menu("Gadgets Menu");
        Menu menuFights = new Menu("Fights Menu");

        // Common MenuItems
        NavigableMenuItem miExit = new NavigableMenuItem("Exit");

        // Main MenuItems
        NavigableMenuItem miPeopleAndTeams = new NavigableMenuItem("Menu People & Teams", menuPeople);
        NavigableMenuItem miGadgets = new NavigableMenuItem("Menu Gadgets", menuGadgets);
        NavigableMenuItem miFights = new NavigableMenuItem("Menu Fights", menuFights);

        // People and Teams MenuItems
        ListableMenuItem lmiHeroes = new ListableMenuItem("List Heroes", "Heroes:", this.heroes);
        ListableMenuItem lmiVillains = new ListableMenuItem("List Villains", "Villains:", this.villains);
        ListableMenuItem lmiTeams = new ListableMenuItem("List Teams", "Teams:", teams);
        ListableMenuItem lmiFans = new ListableMenuItem("List Fans", "Fans:", this.fans);
        ListableMenuItem lmiSearchPeople = new ListableMenuItem(Constants.SEARCH_LABEL, "People & Teams:", peopleAndTeams, true);

        // Gadget MenuItems
        ListableMenuItem lmiGadgets = new ListableMenuItem("List Gadgets", "Gadgets:", this.gadgets);
        ListableMenuItem lmiSearchGadgets = lmiGadgets.makeSelectable(menuGadgets);

        // Tying all the Menu's and MenuItems together
        this.menuMain.addAllOptions(miExit, miPeopleAndTeams, miGadgets, miFights);
        menuPeople.addAllOptions(
            miExit.withPreviousMenu(this.menuMain),
            lmiHeroes.withPreviousMenu(menuPeople),
            lmiVillains.withPreviousMenu(menuPeople),
            lmiTeams.withPreviousMenu(menuPeople),
            lmiFans.withPreviousMenu(menuPeople),
            lmiSearchPeople.withPreviousMenu(menuPeople)
        );
        menuGadgets.addAllOptions(
            miExit.withPreviousMenu(this.menuMain),
            lmiGadgets.withPreviousMenu(menuGadgets),
            lmiSearchGadgets
        );
        menuFights.addAllOptions(miExit.withPreviousMenu(this.menuMain));
    }

    /* GETTERS & SETTERS */

    public Menu getMainMenu() {
        return this.menuMain;
    }
}