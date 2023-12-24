package asymmetrical.app

import asymmetrical.machine.vm.remote_terminal.RemotePage
import asymmetrical.wormholes.pulsar.Galaxy
import symmetrical.cosmic.cosmology.INebula
import symmetrical.cosmic.wormholes.messaging.Message

open class App : IApp {
    lateinit    var galaxy      : Galaxy
    lateinit    var nebula      : INebula
                val remotePage  : RemotePage = RemotePage()
    override fun onMessage(message: Message)  : Boolean {
        return false
    }
    override fun setGalaxy(galaxy: Galaxy) : IApp {
        this.galaxy = galaxy
        return this
    }
    override fun setNebula(nebula:INebula) : IApp {
        this.nebula = nebula
        return this
    }

}