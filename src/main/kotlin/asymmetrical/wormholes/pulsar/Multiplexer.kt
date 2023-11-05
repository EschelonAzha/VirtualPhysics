package asymmetrical.wormholes.pulsar

import asymmetrical.machine.threads.Energy
import asymmetrical.machine.vm.Classes
import asymmetrical.wormholes.pulsar.plugins.galaxy.WSServerPlugin
import asymmetrical.wormholes.pulsar.plugins.ServerPlugin
import asymmetrical.wormholes.pulsar.plugins.http.HttpServerPlugin
import symmetrical.cosmic.cosmology.INebula
import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet
import kotlin.reflect.KClass


class Multiplexer : Energy {
    private val galaxy          : Galaxy
    private val outlet          : IOutlet
    private var serverPlugin    : ServerPlugin
    private var template        : KClass<INebula>

    constructor(galaxy: Galaxy, outlet: IOutlet, INebula:KClass<INebula>) {
        this.galaxy       = galaxy
        this.outlet       = outlet
        this.serverPlugin = HttpServerPlugin().i(this, outlet)
        this.template     = INebula
        println("Open Thread:$this")
    }
    override fun run() : Unit {
        val upgrade  = serverPlugin.run()
        if (upgrade == ServerPlugin.Static.UPGRADE) {
            serverPlugin   = Classes.createInstance(template) as WSServerPlugin
            serverPlugin.i(this, outlet)
            (serverPlugin as WSServerPlugin).setGalaxy(galaxy)
            serverPlugin = galaxy.add(serverPlugin as WSServerPlugin)
            galaxy.remove(serverPlugin as WSServerPlugin)
        }

        println("Close Thread:$this")
    }

}