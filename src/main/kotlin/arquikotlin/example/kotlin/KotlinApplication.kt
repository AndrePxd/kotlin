package arquikotlin.example.kotlin

import ch.qos.logback.classic.joran.JoranConfigurator
import ch.qos.logback.core.joran.spi.JoranException
import ch.qos.logback.core.util.StatusPrinter
import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import ch.qos.logback.classic.LoggerContext

@SpringBootApplication
class KotlinApplication {
	companion object {
		private val logger = LoggerFactory.getLogger(KotlinApplication::class.java)
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(KotlinApplication::class.java, *args)
			val loggerContext = LoggerFactory.getILoggerFactory() as LoggerContext
			try {
				loggerContext.reset()
				val configurator = JoranConfigurator()
				configurator.context = loggerContext
				configurator.doConfigure("src/main/kotlin/logback.xml")
			} catch (je: JoranException) {
				StatusPrinter.print(loggerContext)
			}
		}
	}
}
