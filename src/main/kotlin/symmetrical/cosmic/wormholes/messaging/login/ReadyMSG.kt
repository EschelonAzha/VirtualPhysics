package symmetrical.cosmic.wormholes.messaging.login


import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic.wormholes.messaging.Message
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

class ReadyMSG (
    private val matter: IMatter = Matter(ReadyMSG::class, ReadyMSG::class),
) : Message(),
    IMatter by matter
{
    constructor() : this(
        Matter(ReadyMSG::class, ReadyMSG::class),
    )
    object Static {
        const val LAST      : Int = Message.Static.LAST
    }

    override fun i() : ReadyMSG {
        super.i()
        return this
    }


    override fun absorb(photon: Photon) : Photon {
        matter.check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    override fun getClassId() : String {
        return matter.getClassId()
    }
    private fun radiate() : String {
        return matter.getClassId()+super.emit().radiate()
    }
}