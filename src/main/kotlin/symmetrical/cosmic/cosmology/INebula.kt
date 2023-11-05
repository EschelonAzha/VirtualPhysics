package symmetrical.cosmic.cosmology

import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet

interface INebula {
    fun getOutlet()                 : IOutlet
    fun nextPhase()                 : INebula
    fun onOpen   ()                 : Unit
    fun onClose  ()                 : Unit
    fun onMessage(message:String)   : Boolean
    fun send     (message:String)   : Boolean
}