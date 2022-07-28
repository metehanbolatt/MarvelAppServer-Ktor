package com.metehanbolat.routes

import com.metehanbolat.data.model.Marvel
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private const val BASE_URL = "http://localhost:8080"
private val marvel = listOf(
    Marvel("ironman","Iron Man", "Anthony Edward Tony Stark was a billionaire industrialist, a founding member of the Avengers, and the former CEO of Stark Industries.", "$BASE_URL/marvel/ironman.jpg"),
    Marvel("captain","Captain America", "Cpt. Steven Steve Rogers a.k.a. Captain America, the First Avenger, was rejected by the U.S. Army during World War II due to numerous health problems. He ultimately volunteered for Project Rebirth where he received the Super-Soldier Serum developed by Dr. Abraham Erskine. The serum greatly enhanced his frail body to the peak of human physicality.", "$BASE_URL/static/marvel/captain.jpg"),
    Marvel("drstrange","Dr. Strange", "Doctor Stephen Vincent Strange, M.D., Ph.D is a Master of the Mystic Arts. Originally being a brilliant but arrogant neurosurgeon, Strange got into a car accident which resulted with his hands becoming crippled. Once Western medicine failed him, Strange embarked on a journey to Kamar-Taj, where he was trained by the Ancient One in the ways of Magic and the Multiverse. ", "$BASE_URL/static/marvel/drstrange.jpg"),
    Marvel("spiderman","Spider-Man", "Peter Benjamin Parker is a former high school student who gained spider-like abilities, fighting crime across New York City as the superhero Spider-Man. While Parker juggled all his continued hero duties with the demands of his high-school life, he was approached by Tony Stark who recruited Spider-Man to join the Avengers Civil War, putting Spider-Man into the brief conflict with his personal hero, Captain America. Parker was given a new suit as well as new Stark technology in exchange for his help, allowing him to return back home to continue his own hero work.", "$BASE_URL/static/marvel/spiderman.jpg"),
    Marvel("thor","Thor", "Thor Odinson is the Asgardian God of Thunder, the former king of Asgard and New Asgard, and a founding member of the Avengers. When his irresponsible and impetuous behavior reignited a conflict between Asgard and Jotunheim, Thor was denied the right to become king, stripped of his power, and banished to Earth by Odin. While exiled on Earth, Thor learned humility, finding love with Jane Foster, and helped save his new friends from the Destroyer sent by Loki. Due to his selfless act of sacrifice, Thor redeemed himself in his father's eyes and was granted his power once more, which he then used to defeat Loki's schemes of genocide.", "$BASE_URL/static/marvel/thor.jpg"),
    Marvel("wanda","Scarlet Witch", "Wanda Maximoff is a native of Sokovia who grew up with her fraternal twin brother, Pietro. Born with the latent mythical ability to harness Chaos Magic, she developed a hatred against Tony Stark and rallied anti-American protests after the Novi Grad Bombings killed her parents. Years later, in an effort to help purge their country of strife, the twins joined HYDRA and agreed to undergo experiments with the Scepter under the supervision of Baron Strucker, with the Mind Stone awakening and amplifying Wanda's powers. While her brother developed super-speed, she attained various psionic abilities. When HYDRA fell, the twins joined Ultron to get their revenge on Stark, but abandoned him when they discovered his true intentions to eradicate humanity. Wanda and Pietro joined the Avengers during the Battle of Sokovia to stop Ultron; Pietro was killed during the battle but Wanda survived, and shortly after relocated to the Avengers Compound in the United States of America.", "$BASE_URL/static/marvel/wanda.jpg")
)

fun Route.getHero() {
    get("/marvel/{hero}") {
        call.respond(
            HttpStatusCode.OK,
            marvel.filter { it.id.contains(call.parameters["hero"].toString()) }
        )
    }
}