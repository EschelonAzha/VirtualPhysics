package symmetrical.cosmic._physics._subatomic.balanced.pairs

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiLepton
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.matter.leptons.Lepton
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.spacial.IParticleBeam

open class LeptonPair(
    private val antiMatter: IAntiMatter = AntiMatter(LeptonPair::class),
) : Particle(),
    IAntiMatter by antiMatter
{
    constructor() : this(
        AntiMatter(LeptonPair::class),
    )

    public lateinit var lepton     : Lepton
    public lateinit var antiLepton : AntiLepton


//    constructor(lepton:Lepton, antiLepton:AntiLepton) {
//        i(lepton, antiLepton)
//    }

    fun i(lepton:Lepton, antiLepton:AntiLepton) : LeptonPair {
        this.lepton     = lepton;
        this.antiLepton = antiLepton
        return this
    }

    override fun getClassId() : String {
        return antiMatter.getClassId()
    }
    override fun getIlluminations() : IParticleBeam {
        return antiMatter.getIlluminations()
    }
}