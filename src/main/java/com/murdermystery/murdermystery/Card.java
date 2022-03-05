package com.murdermystery.murdermystery;

public class Card {
    public static final Card[] initialDeck = {
            new SwapCard(0),
            new SwapCard(1),
            new SwapCard(2),
            new SwapCard(3),
            new SwapCard(4),
            new SwapCard(5),
            new SwapCard(6),
            new SwapCard(7),
            new FavourCard(8),
            new FavourCard(9),
            new FavourCard(10),
            new FavourCard(11),
            new FavourCard(12),
            new FavourCard(13),
            new AccuseCard(14),
            new AccuseCard(15),
            new AccuseCard(16),
            new AccuseCard(17),
            new AccuseCard(18),
            new AccuseCard(19),
            new AccuseCard(20),
            new AccuseCard(21),
            new WeaponCard(22, "Knife", "Short blade used to do the stabby stabby"),
            new WeaponCard(23, "Dagger", "Basically just a knife, but it has a fancier name"),
            new WeaponCard(24, "Longsword", "A long sword for a longer boi"),
            new WeaponCard(25, "Fencing Sword",
                    "Waving it around makes you feel like D'Artagnan. Is that how you spell his name?"),
            new WeaponCard(26, "Coffee Pot", "A hazel liquid bubbles within, as if it may suddenly come to life"),
            new WeaponCard(27, "Pizza Roller",
                    "It's circular blade sends shivers into the spines of all pizzas and small children"),
            new WeaponCard(28, "Candle",
                    "A small flame could spread wildly across the whole facility. Or it just killed one person"),
            new WeaponCard(29, "Pistol", "It's a pistol. Figure out how this is a potential murder weapon."),
            new WeaponCard(30, "Revolver", "Literally a big gun. Cmon dude."),
            new WeaponCard(31, "Hunting Dog", "Their sharp face grins with the prospect of a new meal"),
            new WeaponCard(32, "gold teeth", "Biting the wrong artery would cause significant damage"),
            new TimeCard(33, "12am", "Midnight murder :000"),
            new TimeCard(34, "1am", "It might be 1am"),
            new TimeCard(35, "2am", "It may have been 2am"),
            new TimeCard(36, "3am", "Perhaps it was 3am"),
            new TimeCard(37, "4am", "Possibly 4am?"),
            new TimeCard(38, "5am", "Was it 5am?"),
            new TimeCard(39, "6am", "Could it have been 6am?"),
            new TimeCard(40, "7am", "Was the deed done at 7am?"),
            new TimeCard(41, "8am", "As 8am struck, was a murder committed?"),
            new TimeCard(42, "9am", "Bit sus for a murder to be committed at 9am"),
            new TimeCard(43, "10am", "Could a murder have happened at 10am"),
            new TimeCard(44, "11am", "A murder could possibly happen at 11am"),
            new TimeCard(45, "12pm", "Midday murder seems plausible"),
            new TimeCard(46, "1pm", "Did a murder happen at 1pm?"),
            new TimeCard(47, "2pm", "You'd have to be a real sussy baka to murder someone at 2pm"),
            new TimeCard(48, "3pm", "Killing people at 3pm lezzgoooooo"),
            new TimeCard(49, "4pm", "4pm murder; just in time for teatime"),
            new TimeCard(50, "5pm", "Mayhaps it was 5pm"),
            new TimeCard(51, "6pm", "6pm... ;)"),
            new TimeCard(52, "7pm", "Small but not insignificant chances of it being 7pm"),
            new TimeCard(53, "8pm", "It could have been 8pm"),
            new TimeCard(54, "9pm", "Bit late for it to have been 9pm?"),
            new TimeCard(55, "10", "Ehhhhhhhh mayyyyyyyyybeeeeeeeeee 10pm?"),
            new TimeCard(56, "11", "Can't sleep? Just kill someone at 11pm!"),
            new DayCard(57, "Sunday", "Imagine skipping church to commit murder"),
            new DayCard(58, "Monday", "The start of the work week would be a good motive to kill someone"),
            new DayCard(59, "Tuesday", "Nothing interesting happens on Tuesday... except murder?"),
            new DayCard(60, "Wednesday", "Could a murder have taken place during Sinners?"),
            new DayCard(61, "Thursday", "A crime committed on Thor's day; imagine"),
            new DayCard(62, "Friday", "Nothing like a little murder to relieve the stress for Friday"),
            new DayCard(63, "Saturday", "Party hard; murder harder?"),
            new LocationCard(64, "Marine Lab",
                    "A research facility for stingrays, manta rays, maybe other rays... and murder????"),
            new LocationCard(65, "Geology Lab",
                    "A research facility dedicated to rocks. God help the people who look at rocks for a living"),
            new LocationCard(66, "Bathroom", "A place for release, relief, resentment, and maybe re-murder"),
            new LocationCard(67, "Dormitories",
                    "Once thought to provide full privacy, and fluffy beds. Now someone might've died here"),
            new LocationCard(68, "Hallway", "Could a murder have happened here? In plain sight? :0"),
            new LocationCard(69, "Cafeteria", "A place to get nice meals, nice coffee, a nice break. Nice"),
            new LocationCard(70, "Electrical",
                    "Could someone have used the vents system to get into Electrical, and kill someone? Was a body detected here?"),
            new LocationCard(71, "Lounge", "A place for people to lounge around... and maybe die around")

    };

    protected int id;
    protected String name;
    protected String desc;

    public int getID() {
        return id;
    }

    public static Card[] getDeck() {
        return initialDeck;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isPlayable() {
        return false;
    }

    // overrides equals to check two Cards
    @Override

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Card)) {
            return false;
        }
        Card c = (Card) o;
        return id == c.getID() && desc.equals(c.getDesc());
    }
}