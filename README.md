# Venus

Venus is a service provider API for Bukkit plugins, similar to Vault. It provides a centralized way for plugins to access economy, permission, and chat services.

## Features

- Economy API for managing player balances and economies
- Permission API for checking and managing player permissions
- Chat API for managing player chat prefixes, suffixes, and other chat-related functionality
- Service provider registration mechanism for plugins to register their implementations

## Including Venus in Your Project (Coming Soon)
## When Venus is available on JitPack, you’ll be able to include it in your project like this:

### Maven

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.ko-lja</groupId>
        <artifactId>Venus</artifactId>
        <version>1.0-SNAPSHOT</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

### Gradle

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    compileOnly 'com.github.ko-lja:Venus:1.0-SNAPSHOT'
}
```

### Gradle Kotlin DSL

```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.github.ko-lja:Venus:1.0-SNAPSHOT")
}
```

## Using Venus in Your Plugin

### Accessing Services

```kotlin
class YourPlugin : JavaPlugin() {

    override fun onEnable() {
        // Check if Venus is available
        if (server.pluginManager.getPlugin("Venus") == null) {
            logger.severe("Venus not found! Disabling plugin.")
            server.pluginManager.disablePlugin(this)
            return
        }

        // Access economy service
        val economy = VenusAPI.economy
        if (economy != null) {
            logger.info("Found economy provider: ${economy.name}")
        } else {
            logger.warning("No economy provider found!")
        }

        // Access permission service
        val permission = VenusAPI.permission
        if (permission != null) {
            logger.info("Found permission provider: ${permission.name}")
        } else {
            logger.warning("No permission provider found!")
        }

        // Access chat service
        val chat = VenusAPI.chat
        if (chat != null) {
            logger.info("Found chat provider: ${chat.name}")
        } else {
            logger.warning("No chat provider found!")
        }
    }

    // Example of using economy service
    fun depositMoney(playerName: String, amount: Double): Boolean {
        val economy = VenusAPI.economy ?: return false
        val response = economy.depositPlayer(playerName, amount)
        return response.transactionSuccess
    }
}
```

### Registering a Service Provider

If your plugin provides an economy, permission, or chat service, you can register it with Venus:

```kotlin
class YourEconomyPlugin : JavaPlugin(), EconomyProvider {

    override fun onEnable() {
        // Register your economy provider
        val venusPlugin = server.pluginManager.getPlugin("Venus") as? Venus
        if (venusPlugin != null) {
            VenusAPI.registerEconomyProvider(this, venusPlugin, ServicePriority.Normal)
            logger.info("Registered economy provider with Venus")
        } else {
            logger.warning("Venus not found! Economy provider not registered.")
        }
    }

    // Implement EconomyProvider methods
    override val name: String = "YourEconomy"
    override val isEnabled: Boolean = true
    override val currencyNamePlural: String = "Dollars"
    override val currencyNameSingular: String = "Dollar"

    override fun format(amount: Double): String = "$${amount}"

    override fun getBalance(playerName: String): Double {
        // Your implementation
        return 0.0
    }

    override fun has(playerName: String, amount: Double): Boolean {
        // Your implementation
        return false
    }

    override fun withdrawPlayer(playerName: String, amount: Double): EconomyResponse {
        // Your implementation
        return EconomyResponse(
            amount,
            0.0,
            EconomyResponse.ResponseType.FAILURE_GENERAL,
            "Not implemented"
        )
    }

    override fun depositPlayer(playerName: String, amount: Double): EconomyResponse {
        // Your implementation
        return EconomyResponse(
            amount,
            0.0,
            EconomyResponse.ResponseType.FAILURE_GENERAL,
            "Not implemented"
        )
    }

    override fun createPlayerAccount(playerName: String): Boolean {
        // Your implementation
        return false
    }

    override fun hasAccount(playerName: String): Boolean {
        // Your implementation
        return false
    }
}
```

## License

This project is licensed under the GNU Lesser General Public License v3.0 - see the LICENSE file for details.
