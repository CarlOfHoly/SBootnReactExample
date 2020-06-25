package com.example.blog

import org.springframework.web.bind.annotation.*
import java.time.Instant

@RestController
class AppController {
    @RequestMapping("/")
    fun index() = "This is home!"

    @RequestMapping("/tidforis")
    fun getGroup(): Group {
        val group = Group(
                group = "Team Digisos",
                likesIceCream = true,
                timeForIceCream = Instant.now()
        )
        return group
    }

    @CrossOrigin(origins = ["http://localhost:3000"])
    @RequestMapping("/tidforis", method = arrayOf(RequestMethod.POST))
    fun createGroup(@RequestBody newGroup: NewGroup): Group {
        val group = Group(
                group = newGroup.group,
                likesIceCream = newGroup.likesIceCream,
                timeForIceCream = Instant.now()
        )
        return group
    }
}