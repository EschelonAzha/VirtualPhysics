package symmetrical.cosmic._physics._subatomic.balanced.pairs

import symmetrical.cosmic._physics._subatomic.anti_matter.anti_leptons.AntiLepton
import symmetrical.cosmic._physics._subatomic.balanced.Particle
import symmetrical.cosmic._physics._subatomic.matter.leptons.Lepton
import symmetrical.cosmic._physics._subatomic.luminescent.IAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.AntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.IMatterAntiMatter
import symmetrical.cosmic._physics._subatomic.luminescent.MatterAntiMatter
import symmetrical.cosmic._physics._subatomic.spacial.IParticleBeam

open class LeptonPair(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(LeptonPair::class, LeptonPair::class),
) : Particle(),
    IMatterAntiMatter by matterAntiMatter
{
    constructor() : this(
        MatterAntiMatter(LeptonPair::class, LeptonPair::class),
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
        return matterAntiMatter.getClassId()
    }
    override fun getIlluminations() : IParticleBeam {
        return matterAntiMatter.getIlluminations()
    }
}