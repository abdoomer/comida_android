package com.example.comida.dummy.restaurants

import com.example.comida.dummy.foodItems.burgersCategory
import com.example.comida.dummy.foodItems.donutsCategory
import com.example.comida.dummy.foodItems.hotDogCategory
import com.example.comida.dummy.foodItems.pastaCategory
import com.example.comida.dummy.foodItems.pizzaCategory
import com.example.comida.models.Restaurant
import com.example.comida.models.RestaurantCategory
import com.example.comida.models.RestaurantReviews


val availableRestaurants = listOf<Restaurant>(
    Restaurant(
        name = "Five Guys",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = RestaurantCategory.Burger,
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = "https://cdn.sanity.io/images/smy79myr/production/92db13ce00dce2581a033b0e44dc569555331143-2880x1920.jpg",
        availableFoods = burgersCategory,
        reviews = RestaurantReviews()
    ),
    Restaurant(
        name = "Wendy's",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = RestaurantCategory.Burger,
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = "https://www.allrecipes.com/thmb/zs7yLsFVnuaSrYuHuKW2Ewq1LFM=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/AR-Allrecipes-Wendy_s-4x3-4-ba7d3c2d6e0a49af8c2870bc2950e89d.jpg",
        availableFoods = burgersCategory,
        reviews = RestaurantReviews()
    ),
    Restaurant(
        name = "Mcdonald's",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = RestaurantCategory.Burger,
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = "https://cdn.prod.website-files.com/63f6e52346a353ca1752970e/644fb7a67678b8a9fe0db1fe_20230501T1259-96320b36-97db-4f1f-8c02-54f4c2a7cae4.jpeg",
        availableFoods = burgersCategory,
        reviews = RestaurantReviews()
    ),
    Restaurant(
        name = "Hardee's",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = RestaurantCategory.Burger,
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = "https://assets.simpleviewinc.com/simpleview/image/upload/crm/topeka/Hardees_Outboard_4C0-df522f935056a36_df5231a1-5056-a36a-0bef3edef7f59359.jpg",
        availableFoods = burgersCategory,
        reviews = RestaurantReviews()
    ),
    Restaurant(
        name = "Burger King",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = RestaurantCategory.Burger,
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = "https://static4.franchisedirect.ie/dims4/default/876326e/2147483647/strip/true/crop/350x184+0+18/resize/1200x630!/quality/95/?url=https%3A%2F%2Ffranchisedirect-40-prod-ops.s3.amazonaws.com%2F48%2Fcb%2Fd5cbb2101186078636c8cb6adbfb%2Fburger-king.png",
        availableFoods = burgersCategory,
        reviews = RestaurantReviews()
    ),
    Restaurant(
        name = "Krispy Kreme",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = RestaurantCategory.Donuts,
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRKFVsLnGA8vzEx85dXMzw2sBOgsZa3JXWPHA&s",
        availableFoods = donutsCategory,
        reviews = RestaurantReviews()
    ),
    Restaurant(
        name = "Randy's Donuts",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = RestaurantCategory.Donuts,
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcStbrdJe-Qio6vwMjnHW9QrjjASdNL0xY3aDSS2Fd_Zcq59Dad4XedTQ9Z6WlhPZnmHvn8&usqp=CAU",
        availableFoods = donutsCategory,
        reviews = RestaurantReviews()
    ),
    Restaurant(
        name = "Dunkin",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = RestaurantCategory.Donuts,
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ__NronmBZXO0rAAblKxKP48bzvFPLEG8_aA&s",
        availableFoods = donutsCategory,
        reviews = RestaurantReviews()
    ),
    Restaurant(
        name = "Baskin Robbins",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = RestaurantCategory.Donuts,
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZnle4PMMu_RHGuoc69zFuckJbkIkJsczWSg&s",
        availableFoods = donutsCategory,
        reviews = RestaurantReviews()
    ),
    Restaurant(
        name = "Starbucks",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = RestaurantCategory.Donuts,
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = "https://logowski.com/blog/redesign-logo-starbucks-2011_1703502547907.webp",
        availableFoods = donutsCategory,
        reviews = RestaurantReviews()
    ),
    Restaurant(
        name = "Pink's Hot Dogs",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = RestaurantCategory.HotDog,
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRgubt7BjHHsg-n2pGJJB5Od5X3vaE6ns3WGA&s",
        availableFoods = hotDogCategory,
        reviews = RestaurantReviews()
    ),
    Restaurant(
        name = "Nathan's Famous",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = RestaurantCategory.HotDog,
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = "https://d1yjjnpx0p53s8.cloudfront.net/styles/logo-thumbnail/s3/0021/6842/brand.gif?itok=eavcMSfu",
        availableFoods = hotDogCategory,
        reviews = RestaurantReviews()
    ),
    Restaurant(
        name = "Portillo's (Illinois)",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = RestaurantCategory.HotDog,
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT__LDYc8N22CZNAHOJ6SPUpePJO8K3LFQmGw&s",
        availableFoods = hotDogCategory,
        reviews = RestaurantReviews()
    ),
    Restaurant(
        name = "Rutt's Hut",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = RestaurantCategory.HotDog,
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = "https://i.ytimg.com/vi/ogwhdQwOY_g/hqdefault.jpg",
        availableFoods = hotDogCategory,
        reviews = RestaurantReviews()
    ),
    Restaurant(
        name = "Art's Famous Chili",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = RestaurantCategory.HotDog,
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = "https://ca-times.brightspotcdn.com/dims4/default/4dfcab2/2147483647/strip/false/crop/1600x900+0+0/resize/1486x836!/quality/75/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2Fb9%2F5d%2Feb7da362c56a547bbab9cb08fa99%2Fla-dd-15-classic-la-hot-dogs-20150421-photos-001",
        availableFoods = hotDogCategory,
        reviews = RestaurantReviews()
    ),
    Restaurant(
        name = "Domino's",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = RestaurantCategory.Pizza,
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = "https://www.investopedia.com/thmb/g59VZZdx_gfVS5XUzMhIdN1M_dc=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-1992180265-ed0b69a9a1484e47be1edf93362ec650.jpg",
        availableFoods = pizzaCategory,
        reviews = RestaurantReviews()
    ),
    Restaurant(
        name = "Pizza Hut",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = RestaurantCategory.Pizza,
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRRRa0u17L_G5e6WFPUY40D9e7g16WAKGNQOwY18Lo8ot5icOkJwUbPfoZVoIxZqhw0TZQ&usqp=CAU",
        availableFoods = pizzaCategory,
        reviews = RestaurantReviews()
    ),
    Restaurant(
        name = "Tony's Pizza Napoletana",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = RestaurantCategory.Pizza,
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-rOAIWySMR4KEK69J-TYzQnAU9Z_OTfaqrA&s",
        availableFoods = pizzaCategory,
        reviews = RestaurantReviews()
    ),
    Restaurant(
        name = "Pizzeria Sei",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = RestaurantCategory.Pizza,
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = "https://img.freepik.com/premium-vector/italian-pizza-restaurant-vintage-style-design-logo-symbols-food-drink-restaurants_605910-651.jpg?w=360",
        availableFoods = pizzaCategory,
        reviews = RestaurantReviews()
    ),
    Restaurant(
        name = "Napo",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = RestaurantCategory.Pizza,
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQVeBBH8ohXLbmjtDG3i5ivQ9c5nGjLH8ap7w&s",
        availableFoods = pizzaCategory,
        reviews = RestaurantReviews()
    ),
    Restaurant(
        name = "Carbone",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = RestaurantCategory.Pasta,
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = "https://vrconcierge.com/wp-content/uploads/2020/11/carbone-new-york-ny-logo-1.jpg",
        availableFoods = pastaCategory,
        reviews = RestaurantReviews()
    ),
    Restaurant(
        name = "Osteria Mozza",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = RestaurantCategory.Pasta,
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = "https://img.cdn4dd.com/cdn-cgi/image/fit=contain,width=1200,height=672,format=auto/https://doordash-static.s3.amazonaws.com/media/restaurant/cover_square/59c065db-029c-49e0-9de9-910cccf0fdaa.png",
        availableFoods = pastaCategory,
        reviews = RestaurantReviews()
    ),
    Restaurant(
        name = "Lilia",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = RestaurantCategory.Pasta,
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = "https://images.getbento.com/accounts/7bf67b2820625f9f7c33d7b0403a8cca/media/images/17424lilia-logo.png?w=1200&fit=fill&auto=compress,format&cs=origin&h=600&bg=EDEDF1&pad=100",
        availableFoods = pastaCategory,
        reviews = RestaurantReviews()
    ),
    Restaurant(
        name = "Rezdôra",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = RestaurantCategory.Pasta,
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRxlcCtLO1-ipyiWPA_sSP_zgVu8tYinoScyg&s",
        availableFoods = pastaCategory,
        reviews = RestaurantReviews()
    ),
    Restaurant(
        name = "Bestia",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
        category = RestaurantCategory.Pasta,
        isFreeDelivery = true,
        deliveryTime = 45.0,
        isFavorites = false,
        ratingValue = 4.5,
        image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRCW3BhchwdjzCt83Ult_MqfdptP1PViYMvAA&s",
        availableFoods = pastaCategory,
        reviews = RestaurantReviews()
    ),
)