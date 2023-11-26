package symmetrical.cosmic.wormholes.messaging.login

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic.wormholes.messaging.Message
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class AppendMSG(
    private val luminescent: ILuminescent = Luminescent(AppendMSG::class),
) : Message(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(AppendMSG::class),
    )
    object Static {
        const val LAST      : Int = Message.Static.LAST
    }


    override fun i() : AppendMSG {
        super.i()
        return this
    }


    override fun absorb(photon: Photon) : Photon {
        luminescent.check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return luminescent.getClassId()+super.emit().radiate()
    }
    override fun getClassId() : String {
        return luminescent.getClassId()
    }
}