package symmetrical.dictionary.quasiparticles


import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.IMatterAntiMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.luminescent.QuasiParticle


class LoginId (
    private val matterAntiMatter: IMatter = Matter().with(LoginId::class)
) : QuasiParticle(),
    IMatterAntiMatter by matterAntiMatter
{

    fun with(content:String) : LoginId {
        setContent(content)
        return this
    }







    // ########################### EMISSIONS ###########################
    override fun absorb(photon: Photon) : Photon {
        return super.absorb(matterAntiMatter.check(photon).propagate())
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    private fun radiate() : String {
        return matterAntiMatter.getClassId()+super.emit().radiate()
    }
    // ########################### EMISSIONS ###########################
}