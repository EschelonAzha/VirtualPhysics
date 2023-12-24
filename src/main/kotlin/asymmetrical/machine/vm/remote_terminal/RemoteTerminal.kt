package asymmetrical.machine.vm.remote_terminal

import asymmetrical.wormholes.pulsar.Nebula
import symmetrical.cosmic.cosmology.INebula
import symmetrical.cosmic.wormholes.messaging.Messages
import asymmetrical.app.IApp
import websites.logical_society.LogicalSocietyApp
import websites.logical_society.LogicalSocietyGalaxy

open class RemoteTerminal : Nebula {
    protected lateinit var app    : IApp
    private            var phase  : INebula = this

    constructor() {
    }
    override fun onClose() : Unit {
        return
    }
    override fun onMessage(message:String) : Boolean {
        return app.onMessage(Messages.detect(message))
    }
    override fun onOpen() : Unit {
    }

}