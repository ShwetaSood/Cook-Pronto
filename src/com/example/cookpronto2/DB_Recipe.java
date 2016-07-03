package com.example.cookpronto2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB_Recipe extends SQLiteOpenHelper {
	final static String DB_NAME = "db_recipe";

	public DB_Recipe(Context context) {
		super(context, DB_NAME, null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql1= "DROP TABLE IF EXISTS recipe";
				db.execSQL(sql1);
		String sql = "CREATE TABLE IF NOT EXISTS recipe(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,time TEXT, ingre TEXT, prep TEXT, img BLOB,type TEXT,cat TEXT,quant TEXT)";
		db.execSQL(sql);

		ContentValues values = new ContentValues();
		values.put("_id", "1");
		values.put("name", "Potato Rasam");
		values.put("ingre", "potato,water,salt,soy,rice,vinegar,peas,blanched");
		values.put("quant","4 Bell peppers\n1/4 tablespoon Olive oil\n1/2 teaspoon Salt Filling\n3 large Potatoes shredded\n1 Yellow onion shredded\nSalt to taste\n1 teaspoon Ground black pepper\nFew sprinkles of chilly peppers\n1 tablespoon Olive oil")  ;
		values.put("prep","1.Combine all ingredients listed under potatoes in a heavy-bottomed pot and bring to a gentle simmer\n2.Once it reaches a simmer, turn down the heat until there are just very small bubbles in the pot and cook until the potatoes are tender. Cool the potatoes in their cooking liquid in a shallow pan\nOnce cool, cut the potatoes in half lengthwise.\nThe cooking liquid can be used again for the same purpose and so should be reserved.");
		values.put("type","veg");
		values.put("time","15 mins");
		values.put("cat", "Busy Bee");
		values.put("img", R.drawable._1);
		db.insert("recipe", "_id", values);

		values.put("_id", "2");
		values.put("name", "Stuffed Potato");
		values.put("ingre", "bell,olive,oil,salt,potato,onion,chilly");
		values.put("quant", "peppers\n1/4 tab Olive oil\n1/2 teaspoon Salt\nFilling 3 large Potatoes\nshredded 1 Yellow onion\nshredded Salt to taste\n1 teaspoon Ground black peppers\nchilly peppers");
		values.put("prep","Once you done stuffing all the peppers, cover the baking pan with a aluminum foil for the first 15 minutes then remove the alum. foil and continue baking uncovered on 375 degrees for 40 minutes or until potatoes are done.");
		values.put("type","veg");
		values.put("cat","Busy Bee");
		values.put("img", R.drawable._2);
		db.insert("recipe", "_id", values);
		
		values.put("_id", "3");
		values.put("name", " Tasty Aloo ");
		values.put("ingre", "pepper,olive,oil,salt,potato,onion,pepper");
		values.put("quant", "5 grm pepper\n2 olive oil\n1 tsp salt\n2 potato\n1 onion\npepper");
		values.put("prep","Once you done stuffing all the peppers, cover the baking pan with a aluminum foil for the first 15 minutes then remove the alum. foil and continue baking uncovered on 375 degrees for 40 minutes or until potatoes are done.");
		values.put("img", R.drawable._3);
		values.put("time","12 mins");
		values.put("cat","Busy Bee");
		values.put("type","veg");
		db.insert("recipe", "_id", values);
		
		values.put("_id", "4");
		values.put("name", "Tomato sauce");
	    values.put("ingre","olive,onion,garlic,cloves,tomato,pepper,salt,basil,pepper");
		values.put("quant","6 tablespoons Olive Oil\n2 cups Yellow Onions\nchopped 4 whole Garlic cloves\nchopped 8 ounce cans Tomatoes\n1/2 teaspoon Pepper\n2-4 teaspoon Salt\n15-20 large Basil Leaves\nchopped1/4 teaspoon Red pepper flakes");
		values.put("prep", "1.Sauté Onions and Garlic in the olive oil over medium low heat until tender and translucent, about 7 minutes. Add tomatoes, some of the salt and pepper and puree mixture with an immersion blender.\n2.Put over medium heat and let come to a simmer, reduce heat to medium low and simmer for approximately 2 hrs until the sauce has almost reduced by half.\n2.Add Basil and Red Peppers Flakes and cook for 30 more minutes until sauce is thick and not watery\n3.Add more Salt and Pepper if needed.");
		values.put("time","25 mins");
		values.put("type","veg");
		values.put("cat","Dinner Delight");
		values.put("img", R.drawable._4);
		db.insert("recipe", "_id", values);
		
		values.put("_id", "5");
		values.put("name", "Aloo Dum ");
		values.put("ingre", "olive,salt,potato,onion,pepper");
		values.put("quant", "Bell peppers\n1/4 tablespoon Olive oil\n1/2 teaspoon Salt\nFilling 3 large Potatoes\nshredded 1 Yellow onion\n Salt to taste\n1 teaspoon Ground black pepper\nsprinkles of chilly peppers");
		values.put("prep","1.Once you done stuffing all the peppers, cover the baking pan with a aluminum foil for the first 15 minutes then remove the alum. foil and continue baking uncovered on 375 degrees for 40 minutes or until potatoes are done.");
		values.put("type","veg");
		values.put("cat","Dinner Delight");
		values.put("img", R.drawable._5);
		db.insert("recipe", "_id", values);
		
		values.put("_id", "6");
		values.put("name", "Eggs Benedict");
		values.put("ingre","egg,muffin,bacon,sauce");
		values.put("quant","8 Eggs\ncold4 English muffins\n8 Slices Canadian-style bacon\nwarmed 3/4 cup Hollandaise sauce");
		values.put("prep","1.HEAT 2 to 3 inches of water in large saucepan or deep skillet to boiling\n2.ADJUST HEAT to keep liquid simmering gently\n3.BREAK eggs, 1 at a time, into custard cup or saucer.Holding dish close to surface, SLIP egg into water\n4.COOK eggs until whites are completely set and yolks begin to thicken but are not hard, 3 to 5 minutes. Do not stir. LIFT eggs from water with slotted spoon; drain well.\n4.TOP each muffin half with 1 bacon slice, 1 egg and about 1-1/2 Tbsp. hollandaise sauce. ");
		values.put("time","25 mins");
		values.put("img", R.drawable._6);
		values.put("cat","Snacky Eve");
		values.put("type","nonveg");
		db.insert("recipe", "_id", values);
		
		values.put("_id", "7");
		values.put("name", "Potato chat");
		values.put("ingre","cilantro,mint,chilly,salt,sugar,lemon,onion");
		values.put("quant","1 Cup Cilantro\n1/4 Cup Mint leaves\n5-6 Green chilies\nSalt to taste\n1 Teaspoon Sugar\n1 Tablespoon Lemon juice\n1/4 Cup Onion");
		values.put("prep","Once you done stuffing all the peppers, cover the baking pan with a aluminum foil for the first 15 minutes then remove the alum. foil and continue baking uncovered on 375 degrees for 40 minutes or until potatoes are done.");
		values.put("type","veg");
		values.put("cat","Snacky Eve");
		values.put("img", R.drawable._7);
		db.insert("recipe", "_id", values);
		

		
		
		values.put("_id", "8");
		values.put("name", "Fish");
		values.put("ingre", "orange,breadcrumb,paprika,mustard,fish");
		values.put("quant", "6 orange roughy fillets\n1/4 cup fine, dry breadcrumbs\n1 teaspoon Fresh parsley chopped\n1/2 teaspoon Paprika\n1/4 cup low fat plain yogurt\n1 teaspoon Dry mustardnon stick cooking spray");
		values.put("prep","1.Combine breadcrumbs, parsley, and paprika in a shallow dish\n2.Combine yogurt and mustard. Dip fish in yogurt mixture, and dredge in breadcrumb mixture\n3.Spray 4-inch rack and place fish on rack.\n4.Cook on power level high for 3-4 minutes per side. The fish should be flakey and moist. Squeeze fresh lemon over fish.");
		values.put("img", R.drawable._8);
		values.put("type","nonveg");
		values.put("cat","Busy Bee");
		values.put("time","15 mins");
		db.insert("recipe", "_id", values);
		
		values.put("_id", "9");
		values.put("name", "Chicken Saute");
		values.put("ingre", "chicken,oil,clove,ginger,pepper,apple,sugar,ketchup,vinegar,water,soy,cornstarch");
		values.put("quant", "2 pounds boneless chicken breasts\ncut into bite-size pieces\n1 tablespoon olive oil\n(1-2)1 garlic clove\ncrushed 1/4 teaspoon ginger\n3/4 teaspoon crushed red pepper flakes"+"1/4 cup apple juice"+"1/3 cup light brown sugar2 tablespoons ketchup1 tablespoon cider vinegar\n1/2 cup water"+ "\n"+"1/3 cup soy sauce1 tablespoon cornstarch");
		values.put("prep","Once you done stuffing all the peppers, cover the baking pan with a aluminum foil for the first 15 minutes then remove the alum. foil and continue baking uncovered on 375 degrees for 40 minutes or until potatoes are done.");
		values.put("img", R.drawable._9);
		values.put("type","nonveg");
		values.put("cat","Dinner Delight");
		values.put("time","30 mins");
		db.insert("recipe", "_id", values);
		
		
		
		values.put("_id", "10");
		values.put("name", "Tomato Garlic Pasta");
		values.put("ingre", "oil,garlic,tomato,salt,pepper,cheese");
		values.put("quant", "tablespoons Olive oil plus more for boiling pasta\n6 cloves Garlic more or less to taste minced \nItalian seasoning \n6 ounces Dry spaghetti \nsalt and pepper to taste\nAsiago cheese or Parmesan cheese");
		values.put("prep","1.Boil salted water for pasta (add a little oil to the water).\n2.Heat 3 tbs olive oil over medium heat, and add the garlic.\n3.Heat for about 1 minute, and then add the tomatoes.Heat over medium-low heat while the pasta cooks.Once the pasta is done, drain, and toss with tomato mixture.Garnish with Asiago or Parmesan cheese, and serve with a crusty bread and a salad..");
		values.put("img", R.drawable._10);
		values.put("time","15 mins");
		values.put("cat","Busy Bee");
		values.put("type","veg");
		db.insert("recipe", "_id", values);
		
		
		values.put("_id", "11");
		values.put("name", "Potato Stuffed ");
		values.put("ingre","pepper,oil,salt,potato,onion");
		values.put("quant", "Bell peppers\n4 tablespoon Olive oil\n1/2 teaspoon Salt\nFilling3 large Potatoes\nshredded1 Yellow onion; shreddedSalt to taste1 teaspoon Ground black peppersprinkles of chili peppers");
		values.put("prep","Once you done stuffing all the peppers, cover the baking pan with a aluminum foil for the first 15 minutes then remove the alum. foil and continue baking uncovered on 375 degrees for 40 minutes or until potatoes are done.");
		values.put("time","25 mins");
		values.put("cat","Healthy Pick");
		values.put("type","veg");
		values.put("img", R.drawable._11);
		db.insert("recipe", "_id", values);
		
		
		
		values.put("_id", "12");
		values.put("name", "Cauliflower Tadka");
		values.put("ingre", "oil,tomato,cauliflower,salt,pepper,garlic");
		values.put("quant", "3 tablespoons Olive oil\n2 Tomatoes (vine)\nchopped1 Cauliflower (small/medium)\n1 teaspoon Salt\n1/4 teaspoon Black pepper\n1 tablespoon Cumin seeds\n2 cloves Fresh garlic");
		values.put("prep","1.Heat olive oil in medium sized pot\n2. Add tomatoes and stir.\n3. Add cauliflower, salt, pepper, and cumin seeds. Stir and cover with lid. Cook for about 10 minutes or until cauliflower is just tender when pierced with a fork.4. Add garlic and cook for 1 more minute, stirring as the ingredients finish cooking.Optional: Cook 1/2 sliced yellow onion with the other vegetables, sauteing for 5 minutes before adding in the tomato.");
		values.put("img", R.drawable._12);
		values.put("time","15 mins");
		values.put("type","veg");
		values.put("cat","Healthy Pick");
		db.insert("recipe", "_id", values);
		
		values.put("_id", "13");
		values.put("name", "Tomato seafood soup");
		values.put("ingre","plum,tomato,olive,onion,pepper,garlic,salt");
		values.put("quant","8 to 10 ripe plum tomatoes or 1 can\n(15 ounces) diced fire-roasted tomatoes\nundrained 3 tablespoons olive oil\n3 large shallots or 1 white onion"+"finely chopped 1 small leek\ntrimmed, chopped1 red bell pepper\nseeded, chopped, or 1 bottled roasted red bell pepper\ndiced6 large cloves garlic\nfinely chopped or crushed 1 quart vegetable broth1 bottle\n(8 ounces) clam juice or water\n1/2 cup dry white wine\n1/4 cup tomato paste1 teaspoon salt or to taste");
		values.put("prep","1.If using fresh tomatoes, heat the broiler to high; put tomatoes on a foil-lined baking sheet.\n2.Broil 6 inches from the heat source, turning occasionally, until the skin is lightly charred on all sides, 10-12 minutes.\n3.Cool, peel and chop coarsely, collecting all the juices.\n4.Heat the oil in a 4- to 5-quart Dutch oven or deep saucepan. Cook the shallots and leek until soft, about 4 minutes. Stir in the red pepper and garlic; cook 1 minute. Add the tomatoes, broth, clam juice, wine, tomato paste, salt and smoked paprika. Simmer 15 minutes. (This base can be refrigerated, covered, up to 3 days. Shortly before serving, heat the tomato mixture to a simmerAdd the clams; cook 3 minutes. Add the shrimp and fish; cook 2 minutes. Add the scallops; cook 1 minute more or until all fish is opaque but still tender. Ladle the soup into wide serving bowls. Place a dollop of the garlic mayo into the center. Sprinkle with parsley and chives.");
		values.put("time","45 mins");
		values.put("cat","Dinner Delight");
		values.put("type","nonveg");
		values.put("img", R.drawable._13);
		db.insert("recipe", "_id", values);
		
		
		values.put("_id", "14");
		values.put("name", "Egg and Tomato");
		values.put("ingre","tomato,egg,milk,salt,pepper,oil");
		values.put("quant","4 Plum tomatoes\n4 Eggs\n3 Scallions\n1/2 cup Milk Sugar\nSalt\ntasteBlack pepper to taste");
		values.put("prep","1.Take the skin off the tomatoes by making a cut on top and submerging them in boiling hot water for one minute, and cut into pieces. Beat the eggs with the milk, and some salt and pepper\n2.Add some oil to a wok or large skillet, and scramble the eggs. Remove scrambled eggs from the pan and set aside.");
		values.put("time","15 mins");
		values.put("type","nonveg");
		values.put("cat","Snacky Eve");
		values.put("img", R.drawable._14);
		db.insert("recipe", "_id", values);
		
		values.put("_id", "15");
		values.put("name", "Pita Pocket");
		values.put("ingre","oil,spinach,egg,pepper,wheat");
		values.put("quant","Natural spray oil\n2cups packed baby spinach (or 1 cup frozen; then thawed and squeezed)\n3 cage-free eggs beaten \n1/8 teaspoon sea salt \n1/8 teaspoon ground black pepper \n 1/3cup grated mozzarella cheese2 whole wheat pitas");
		values.put("type","nonveg");  
		values.put("cat","Healthy Pick");  
		values.put("time","6 mins");
		values.put("prep","1.Heat a large skillet over medium-high heat\n2.Spray with oil, add spinach and cook, tossing often, until just wilted, about 1 minute. Add eggs, salt and pepper and cook, tossing gently, until fluffy and cooked through, 3 to 4 minutes.\n3.Remove from heat, add mozzarella and toss again. Spoon egg mixture onto pitas, fold in half and serve right away or wrap in foil to eat on the go.");
		values.put("img", R.drawable._15);
		db.insert("recipe", "_id", values);
		
		values.put("_id", "16");
		values.put("name", "Simple Sesame Noodles");
		values.put("ingre","noodles,soy,garlic,oil,sesame,pepper");
		values.put("quant","1/2 pound Oriental noodles\n2 tablespoon Soy sauce\n2 cloves Garlic\n1/4 cup Vegetable oil\n1 teaspoon Sesame oil\n1 tablespoon Pepper flakes");
		values.put("prep","1.Possibly saute garlic in oil.\n2.Add the rest into the cooked oriental noodles and toss.");
		values.put("img", R.drawable._16);
		values.put("time","10 mins");
		values.put("cat","Snacky Eve");
		values.put("type","veg");
		db.insert("recipe", "_id", values);
		
		values.put("_id", "17");
		values.put("name", "Cereals Grains");
		values.put("ingre","coconut,water,oats,millet,quinoa,honey,fruit,nut");
        values.put("quant","2 cups unsweetened nondairy beverage\ncoconut water or 3/4 cup buck wheat groats (kasha)"+ "\n"+"rolled oats, millet, rinsed quinoa, pearled barley or brown rice1 teaspoon pure vanilla extract\n1/2 teaspoon ground cinnamon\n1 teaspoon honey (optional)1 cup fresh or thawed frozen unsweetened fruit\n1/2 cup dried fruit\n2 tablespoons nuts or seeds\ntoasted or raw");
        values.put("prep","1.Bring liquid to a boil in a medium saucepan.\n2.Stir in grain or rice and return to a boil.\n3.Lower heat, add vanilla, cinnamon and honey.\n4.Cover pan and simmer until tender, 10 to 50 minutes. Kasha will take about 10 minutes; rolled oats will take 15 to 20 minutes; millet will take about 25 minutes; quinoa will take about 30 minutes; pearled barley will take 45 to 50 minutes; brown rice will take about 50 minutes.");
		values.put("time","15 mins");
		values.put("cat","Healthy Pick");
		values.put("type","veg");
		values.put("img", R.drawable._17);
		db.insert("recipe", "_id", values);
		
		values.put("_id", "18");
		values.put("name", "Tomato Basil Soup");
		values.put("ingre","oil,onion,garlic,basil,tomato,cheese,milk,bread");
        values.put("quant","1 tablespoon Extra virgin olive oil\n1/2 cups Onion\nPrechopped 3 Garlic cloves\nChopped 3/4 cup Fresh basil\nChopped 28 ounce Fire-roasted diced tomatoes\n1/3-less-fat cream cheese\ncups 1% low-fat milk\n1/4 teaspoon Salt\n1/4 teaspoon Black pepper\n12 Slices French bread\n1/2-inch thick1 Garlic cloves\ncheese shredded");
       values.put("prep","1.Preheat broiler to high;Heat olive oil in a saucepan over medium-high heat.\n2.Add onion; sauté 3 minutes. Stir in garlic; cook for 1 minute.\n3.Add basil and tomatoes; bring to a boil.\n4.Stir in cheese until melted. Place mixture in blender, and blend until smooth. Return to pan; stir in milk, salt, and pepper. Return to medium-high; cook 2 minutes;Place bread on baking sheet; lightly coat with spray. Broil 1 minute. Rub garlic over toasted side; turn bread over. Top with Asiago; broil 1 minute.");
	   values.put("time","45 mins");
		values.put("cat","Snacky Eve");
		values.put("type","veg");
		values.put("img", R.drawable._18);
		db.insert("recipe", "_id", values);
		
		values.put("_id", "19");
		values.put("name", "Lime Sesame Salad");
	values.put("ingre","lettuce,cucumber,sesame,lime,oil");
values.put("quant","arugula lettuce\n2 avocado 1 lebanese cucumber\n4 servings smoked salmon\n2 tbsp sesame seeds\n1 lime\n1 drop sesame oil optional");
        values.put("time","15 mins");
		values.put("cat","Healthy Pick");
		values.put("type","veg");
		values.put("img", R.drawable._19);
		db.insert("recipe", "_id", values);
		
		values.put("_id", "20");
		values.put("name", "Melon Lime Salad");
		values.put("ingre","melon,cucumber,cherry,tomato,mint,wine,vinegar,honey,oil");
		values.put("quant","1/2 charentais melon; or canteloupe\n1/2 Cucumber\n175 g vine ripened cherry tomatoes\n1 tbsp mint\nfinely shredded mint\n12 thin slices Serrano ham for the vinaigrette\n2 tsp Red wine vinegar\n0.5 tsp clear honey\n1.5 tbsp Extra virgin olive oil");
values.put("prep","1.Cut the melon into four, scoop out and discard the seeds.\n2.Slice the flesh away from the skin and cut into small pieces, about the same size as the halved cherry tomatoes. Peel the cucumber, deseed it and cut into half moons.Put the melon, tomatoes and cucumber in a serving bowl with the shredded mint and toss together gently until the mint is well distributed.Make the vinaigrette by whisking the vinegar, honey and oil together. Season and stir into the salad. Arrange the Serrano ham, on 4 plates and serve with the salad.");
	      values.put("time","60 mins");		
	 values.put("cat","Healthy Pick");
		values.put("type","veg");
		values.put("img", R.drawable._20);
		db.insert("recipe", "_id", values);
		
		values.put("_id", "21");
		values.put("name", "Melon tomato salad");
		values.put("ingre","melon,cucumber,cherry,tomato,mint,wine,vinegar,honey,oil");
		 values.put("quant","1/2 charentais melon; or canteloupe\n1/2 Cucumber\n175 g vine ripened cherry tomatoes\n1 tbsp mint\nshredded mint\n12 thin slices Serrano ham for the vinaigrette\n2 tsp Red wine vinegar\n0.5 tsp clear honey\n1.5 tbsp Extra virgin olive oil");
   
    values.put("prep","1.Cut the melon into four, scoop out and discard the seeds.\n2.Slice the flesh away from the skin and cut into small pieces, about the same size as the halved cherry tomatoes.\n3.Peel the cucumber, deseed it and cut into half moons.Put the melon, tomatoes and cucumber in a serving bowl with the shredded mint and toss together gently until the mint is well distributed.Make the vinaigrette by whisking the vinegar, honey and oil together. Season and stir into the salad. Arrange the Serrano ham, on 4 plates and serve with the salad.");
	 values.put("time","60 mins");		
	 values.put("cat","Healthy Pick");
		values.put("type","veg");
		values.put("img", R.drawable._21);
		db.insert("recipe", "_id", values);
		
		values.put("_id", "22");
		values.put("name", "Mint Corn Salad");
		values.put("ingre","tomato,mint,wine,vinegar,honey,corn");
    values.put("quant","1/2 cup of corn; or canteloupe\n1/2 Cucumber\n175 g vine ripened cherry tomatoes\n1 tbsp mint\nfinely shredded mint\n12 thin slices Serrano ham for the vinaigrette\n2 tsp Red wine vinegar\n0.5 tsp clear honey\n1.5 tbsp Extra virgin olive oil");
     values.put("prep","1.Cut the melon into four, scoop out and discard the seeds.Slice the flesh away from the skin and cut into small pieces, about the same size as the halved cherry tomatoes.\n2.Peel the cucumber, deseed it and cut into half moons.Put the melon, tomatoes and cucumber in a serving bowl with the shredded mint and toss together gently until the mint is well distributed.Make the vinaigrette by whisking the vinegar, honey and oil together. Season and stir into the salad. Arrange the Serrano ham, on 4 plates and serve with the salad.");
	 values.put("time","60 mins");		
	 values.put("cat","Healthy Pick");
		values.put("type","veg");
		values.put("img", R.drawable._22);
		db.insert("recipe", "_id", values);
		
		values.put("_id", "23");
		values.put("name", "Chicken Spicy Roll");
		values.put("ingre","butter,chicken,mayonnaise");
		values.put("quant","1 Whole Turkey Breast\n1/2 cups Butter\nmelted 1 can Chicken Broth\n3 Tbls Mayonnaise");
		values.put("prep","1.Clean thawed turkey breast and place in a baking pan (foil is good for cleanup). Melt butter.\n2.Pour chicken broth and melted butter over turkey breast and spread the mayonnaise all over skin.\n3.Bake as directed. I basted about every 30 minutes. This method is not too dry and not too moist, and the taste is wonderfu");
   values.put("time","45 mins");		
	 values.put("cat","Dinner Delight");
		values.put("type","nonveg");
		values.put("img", R.drawable._23);
		db.insert("recipe", "_id", values);
		
		values.put("_id", "24");
		values.put("name", "Lasagna");
		values.put("ingre","sauce,lasagna,cheese,egg,salt,pepper,mozzarella");
		values.put("quant","1 1/2 lbs chopmeat\n1/2 cups spaghetti sauce; (or 1 26-oz jar)\n1 package no cook Lasagna noodles\n1 LARGE container of Ricotta Cheese\n2 Eggs\nsalt and pepper\nbig handful of grated parmesan cheese"+ "\n"+"2 bags mozzarella cheese ");
         values.put("prep","1.Brown the chopmeat and then make Mom's Spaghetti sauce in same pot meat.\n2.Mix ricotta, eggs, salt and pepper, italian seasoning and parmesan cheeseStart layering sauce, then noodles, ricotta and end spaghetti sauce.\n3.Top shredded mozzarella cheese, and then sprinkle some more parmesan cheese\n4.You can add some mozzarella within your layers as wellBake @ 350 for 45 min to 1 hour. Let slightly cool before serving");		
		values.put("time","60 mins");		
	 values.put("cat","Dinner Delight");
		values.put("type","nonveg");
		values.put("img", R.drawable._24);
		db.insert("recipe", "_id", values);
		
		values.put("_id", "25");
		values.put("name", "Party Pizzas");
		values.put("ingre","dough,sauce,mozzarella,pepper,sausage");
		values.put("quant","1 pound Pizza Dough\n1 can (15 oz) Pizza Sauce\n1 package (8 oz) Mozzarella grated\n1 package (8 oz) Pepperoni\n1/2 pound Sausages");
		values.put("prep","1.Preheat oven to 450 degrees. Roll out pizza dough.\n2.Use large round cookie cutter or biscuit cutters (2-3 inches) to cut out dough.\n3.Place on cookie sheet. Top with sauce, cheese and meats. Bake for 10-12 minutes.");
		values.put("time","45 mins");		
	 values.put("cat","Snacky Eve");
		values.put("type","nonveg");
		values.put("img", R.drawable._25);
		db.insert("recipe", "_id", values);
		
		values.put("_id", "26");
		values.put("name", "Honey Mint Syrup");
		values.put("ingre","lime,honey,mint,cantaloupe,strawberry,kiwi,peel,grapes");
		values.put("quant","1/4 cup Fresh lime juice\n1/4 cup Honey\n1/4 cup fresh mint\n3-pound cantaloupe; halved, seeded\n12-ounce basket strawberries\n4 medium kiwis\npeeled, cut into 1/2-inch pieces\n1/2 cups seedless grapes");
	values.put("prep","1.Whisk lime juice, honey and mint in large bowl to blend.\n2.Using melon baller, scoop out cantaloupe.Add all fruit to syrup in bowl; toss to combine.Let stand 15 minutes to allow flavors to blend. (Can be made 3 hours ahead. Cover and chill.)Spoon fruit into goblets.");
	values.put("time","45 mins");		
	 values.put("cat","Healthy Pick");
		values.put("type","veg");
		values.put("img", R.drawable._26);
		db.insert("recipe", "_id", values);
		
		values.put("_id", "27");
		values.put("name", "Spinach Salsa");
		values.put("ingre","spinach,oil,pepper,bean,garlic,pepper");
		values.put("quant","8 cups coarsely chopped spinach leaves\n4 cups hot cooked cavatappi; (about 6 ounces uncooked)\n2 tablespoons olive oil\n1/4 teaspoon salt\n1/4 teaspoon pepper\n(19-ounce) cannelini beans\n2 garlic cloves crushed\n1/2 cup (2 ounces) shredded Asiago cheese\nFresh ground black pepper (optional)");
		values.put("prep","1.Combine all ingredients in a large bowl, and toss well.\n2.Sprinkle with fresh ground black pepper, if desired.");
		values.put("time","20 mins");		
	 values.put("cat","Busy Bee");
		values.put("type","veg");
		values.put("img", R.drawable._27);
		db.insert("recipe", "_id", values);
		
		
	}


	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS recipe");
		onCreate(db);

	}

}