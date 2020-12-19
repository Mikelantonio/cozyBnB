package dev.trizio.cozybnb

import com.github.javafaker.Faker
import dev.trizio.cozybnb.models.UsersEntity
import dev.trizio.cozybnb.service.UsersEntityService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.data.repository.init.Jackson2RepositoryPopulatorFactoryBean
import org.springframework.stereotype.Service
import javax.persistence.EntityManager


@SpringBootApplication
class CozybnbApplication{

	@Autowired
	private lateinit var userService : UsersEntityService

	@Bean
	fun loadWithEntityFaker(){

		userService.loadUsers()
	}


	/*@Bean
	fun getRespositoryPopulator(): Jackson2RepositoryPopulatorFactoryBean? {
		val factory = Jackson2RepositoryPopulatorFactoryBean()
		factory.setResources(arrayOf<Resource>(ClassPathResource("data.json")))
		return factory
	}*/


}

fun main(args: Array<String>) {
	runApplication<CozybnbApplication>(*args)
}
