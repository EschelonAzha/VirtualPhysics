package asymmetrical.app

import asymmetrical.wormholes.pulsar.Galaxy
import symmetrical.cosmic.cosmology.INebula
import symmetrical.cosmic.wormholes.messaging.Message

interface IApp {

    fun onMessage(message: Message)  : Boolean;
    fun setGalaxy(galaxy : Galaxy)   : IApp
    fun setNebula(nebula : INebula)  : IApp;
}