public class Fields {

    Board field_0 = new Board("The Void", 0, "Oh no, you've rolled zero! Your turn is now skipped!");
    Board field_1 = new Board("Theif's den", 100,
            "You are the one and only theif! You steal 100 points from the other player.");
    Board field_2 = new Board("The Tower", 250,
            "You walk up to a huge tower, and climb the stairs - on the top of the stairs you find 250 gold!");
    Board field_3 = new Board("The Crater", -100,
            "You carefully approach the crater - when you peek into the dark 20 feet drop, a gust of wind blows you over the edge. When you wake up at the buttom, you have to take the bus to the top again - the ticket is 100 gold.");
    Board field_4 = new Board("Palace Gates", 100,
            "You approache the huge gates of the palace. You look up, and you feel tiny standing below those huge metalgates. You look downm and it seems someone dropped 100 gold on the ground - it's your lucky day!");
    Board field_5 = new Board("Cold Desert", -20,
            "The cold, dark desert in the night is a weird contrast to it's unforgiving heat during the day. You walk by a blanket-selling-shop and buy one for 20 gold.");
    Board field_6 = new Board("Walled City", 180,
            "The walls of the Walled City keep you safe from harm from the outside - but you also yearn for the freedom on the outside - you tell your stories at a bar down town, and the locals tip you 180 gold for intertaining them that night.");
    Board field_7 = new Board("The Monastrey", 0,
            "A monastery is a place for salvation and rest - here is no gold, only peace.");
    Board field_8 = new Board("Black Cave", -70,
            "You've heard rumors of the Black Cave. Terriple rumors. You walk up to the cave, but the tickets are 70 gold a piece. You buy one, and joins the next guided tour. It was SUPER scary!");
    Board field_9 = new Board("Huts in the Mountains", 60,
            "The wind is howling in these mountains - it freezing and you need shelter. Luckily you come across a couple of huts in the mountain. In there you find rest, warmth and 60 gold.");
    Board field_10 = new Board("The Werewall", -80,
            "Oh wall, why do you have so big teeth? Oh no, it's a werewall! Don't get bitten! (You get bitten, and a has to pay 80 gold for a tetanus shot) - but you also get a lollipop! Roll the dice again!");
    Board field_11 = new Board("The Pit", -50,
            "The Pit is so deep you can't even see the bottom of it - you read a sign saying 'Wishing Pit' - you try your luck, make a wish and throw 50 gold down the pit - your wish doesn't come true.");
    Board field_12 = new Board("The Goldmine", 650,
            "We're rich! Hallelujah! Someone forgot to lock the doors at the gold mine, you go in there and fill your pockets - it adds up to 650 gold!");

}

/*
 * int sum = 0;
 * int points = 0;
 * 
 * if(sum==0)
 * {
 * System.out.println("Oh no, you've rolled zero! Your turn is now skipped!");
 * System.out.println("Your total is now " + points + " gold.");
 * 
 * }else if(sum==1)
 * {
 * System.out.
 * println("You are the one and only theif! You steal 100 points from the other player."
 * );
 * points = points + 100;
 * System.out.println("Your total is now " + points + " gold.");
 * // Deduct the other players points
 * 
 * }else if(sum==2)
 * {
 * System.out.println(
 * "You walk up to a huge tower, and climb the stairs - on the top of the stairs you find 250 gold!"
 * );
 * points = points + 250;
 * System.out.println("Your total is now " + points + " gold.");
 * 
 * }else if(sum==3)
 * {
 * System.out.println(
 * "You carefully approach the crater - when you peek into the dark 20 feet drop, a gust of wind blows you over the edge. When you wake up at the buttom, you have to take the bus to the top again - the ticket is 100 gold."
 * );
 * points = points - 100;
 * System.out.println("Your total is now " + points + " gold.");
 * 
 * }else if(sum==4)
 * {
 * System.out.println(
 * "You approache the huge gates of the palace. You look up, and you feel tiny standing below those huge metalgates. You look downm and it seems someone dropped 100 gold on the ground - it's your lucky day!"
 * );
 * points = points + 100;
 * System.out.println("Your total is now " + points + " gold.");
 * 
 * }else if(sum==5)
 * {
 * System.out.println(
 * "The cold, dark desert in the night is a weird contrast to it's unforgiving heat during the day. You walk by a blanket-selling-shop and buy one for 20 gold."
 * );
 * points = points - 20;
 * System.out.println("Your total is now " + points + " gold.");
 * 
 * }else if(sum==6)
 * {
 * System.out.println(
 * "The walls of the Walled City keep you safe from harm from the outside - but you also yearn for the freedom on the outside - you tell your stories at a bar down town, and the locals tip you 180 gold for intertaining them that night."
 * );
 * points = points + 180;
 * System.out.println("Your total is now " + points + " gold.");
 * 
 * }else if(sum==7)
 * {
 * System.out.
 * println("A monastery is a place for salvation and rest - here is no gold, only peace."
 * );
 * System.out.println("Your total is now " + points + " gold.");
 * 
 * }else if(sum==8)
 * {
 * System.out.println(
 * "You've heard rumors of the Black Cave. Terriple rumors. You walk up to the cave, but the tickets are 70 gold a piece. You buy one, and joins the next guided tour. It was SUPER scary!"
 * );
 * points = points - 70;
 * System.out.println("Your total is now " + points + " gold.");
 * 
 * }else if(sum==9)
 * {
 * System.out.println(
 * "The wind is howling in these mountains - it freezing and you need shelter. Luckily you come across a couple of huts in the mountain. In there you find rest, warmth and 60 gold."
 * );
 * points = points + 60;
 * System.out.println("Your total is now " + points + " gold.");
 * 
 * }else if(sum==10)
 * {
 * System.out.println(
 * "Oh wall, why do you have so big teeth? Oh no, it's a werewall! Don't get bitten! (You get bitten, and a has to pay 80 gold for a tetanus shot) - but you also get a lollipop! Roll the dice again!"
 * );
 * points = points - 80;
 * System.out.println("Your total is now " + points + " gold.");
 * // SPILLEREN FÅR EN EKSTRA TUR??
 * 
 * }else if(sum==11)
 * {
 * System.out.println(
 * "The Pit is so deep you can't even see the bottom of it - you read a sign saying 'Wishing Pit' - you try your luck, make a wish and throw 50 gold down the pit - your wish doesn't come true."
 * );
 * points = points - 50;
 * System.out.println("Your total is now " + points + " gold.");
 * 
 * }else if(sum==12)
 * {
 * System.out.println(
 * "We're rich! Hallelujah! Someone forgot to lock the doors at the gold mine, you go in there and fill your pockets - it adds up to 650 gold!"
 * );
 * points = points + 650;
 * System.out.println("Your total is now " + points + " gold.");
 * 
 * }
 */
