package websites._phases

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic.cosmology.INebula
import symmetrical.cosmic.cosmology.NebulaPhase
import symmetrical.cosmic.wormholes.messaging.login.LoginMSG

class LoginPhase : NebulaPhase, INebula {
    constructor(nebula:INebula) : super(nebula) {

    }
    override fun onClose() : Unit {
        println("OnClose is fired once")
        return
    }
    override fun onMessage(payload:String) : Boolean {
        val message : LoginMSG = LoginMSG().i()
        message.getUserId().setString("sdesofi")
        message.getPassword().setString("password")

        val emission = message.emit().radiate()
        val (clone, remainder) = Absorber.materialize(emission)
        println(emission)
        if (payload == "Hello Server")
            return !send(emission)

        return true;
    }
    override fun onOpen() : Unit {
        return

    }

}