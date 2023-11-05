package asymmetrical.machine.vm.remote_terminal

import asymmetrical.wormholes.pulsar.Nebula
import symmetrical.cosmic.cosmology.INebula
import symmetrical.cosmic.wormholes.messaging.Messages
import asymmetrical.app.IApp
import websites.logical_society.LogicalSocietyApp
import websites.logical_society.LogicalSocietyGalaxy

open class RemoteTerminal : Nebula {
    private            var phase  : INebula = this
    protected lateinit var app    : IApp

    constructor() {
    }
    override fun onOpen() : Unit {
    }
    override fun onMessage(message:String) : Boolean {
        return app.onMessage(Messages.detect(message))
    }
    override fun onClose() : Unit {
        return
    }
}