package symmetrical.cosmic.physics.subatomic.balanced.pairs

import symmetrical.cosmic.physics.subatomic.anti_matter.anti_leptons.AntiLepton
import symmetrical.cosmic.physics.subatomic.balanced.Particle
import symmetrical.cosmic.physics.subatomic.balanced.values.Field
import symmetrical.cosmic.physics.subatomic.matter.leptons.Lepton
import symmetrical.cosmic.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.cosmic.physics.subatomic.luminescent.MatterAntiMatter
import symmetrical.cosmic.physics.subatomic.spacial.IParticleBeam
/*
https://en.wikipedia.org/wiki/Pair_production
 */
open class LeptonPair(
    private val matterAntiMatter: IMatterAntiMatter = MatterAntiMatter(LeptonPair::class, LeptonPair::class),
) : Particle(),
    IMatterAntiMatter by matterAntiMatter
{
    constructor() : this(
        MatterAntiMatter(LeptonPair::class, LeptonPair::class),
    )

    companion object {
        fun field(pair:LeptonPair) : Field {
            return pair._lepton.getWavelength().getField()
        }
        fun _field(pair:LeptonPair) : Field {
            return pair._antiLepton.getWavelength().getField()
        }
    }

    public lateinit var _lepton     : Lepton
    public lateinit var _antiLepton : AntiLepton


//    constructor(lepton:Lepton, antiLepton:AntiLepton) {
//        i(lepton, antiLepton)
//    }

    fun i(lepton:Lepton, antiLepton: AntiLepton) : LeptonPair {
        this._lepton     = lepton;
        this._antiLepton = antiLepton
        return this
    }

    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    override fun getIlluminations() : IParticleBeam {
        return matterAntiMatter.getIlluminations()
    }
}