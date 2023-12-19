package websites.logical_society

import symmetrical.cosmic.cosmology.INebula
import symmetrical.cosmic.wormholes.messaging.Message
import symmetrical.cosmic.wormholes.messaging.login.ReadyMSG
import symmetrical.dom.Dom
import symmetrical.dom.properties.region.DomHeight
import asymmetrical.app.App
import symmetrical.cosmic._physics._subatomic.balanced.Particle

class LogicalSocietyApp : App {

    constructor() {
    }

    override fun onMessage(message: Message) : Boolean {
        if (message::class == ReadyMSG::class) {
            val property = DomHeight(99999999)
            val child = Dom()
            val parent = Dom()
            parent.addProperty(property)
            parent.append(child)
            message.add(parent)
            message.createUniqueId()
            message.getTime().setTime(2)
            message.getCharge().setCharge(1)
            message.getMass().setMass(3.5)
            message.getSpace().setSpace(Particle())
            message.getTemperature().setTemperature(100)
         //   message.getWavelength().setWavelength(22)
            val emission = message.emit().radiate()
            nebula.send(emission)
        }
        return true
    }
}