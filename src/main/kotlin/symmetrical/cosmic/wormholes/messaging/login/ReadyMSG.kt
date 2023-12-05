package symmetrical.cosmic.wormholes.messaging.login


import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic.wormholes.messaging.Message
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter

class ReadyMSG (
    private val antiMatter: IAntiMatter = AntiMatter(ReadyMSG::class, ReadyMSG::class),
) : Message(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(ReadyMSG::class, ReadyMSG::class),
    )
    object Static {
        const val LAST      : Int = Message.Static.LAST
    }

    override fun i() : ReadyMSG {
        super.i()
        return this
    }


    override fun absorb(photon: Photon) : Photon {
        antiMatter.check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return antiMatter.getClassId()+super.emit().radiate()
    }
    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
}