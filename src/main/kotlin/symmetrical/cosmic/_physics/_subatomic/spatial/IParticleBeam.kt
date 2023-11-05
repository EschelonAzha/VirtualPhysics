package symmetrical.cosmic._physics._subatomic.spatial

import symmetrical.cosmic._physics._subatomic.balanced.IParticle
import symmetrical.cosmic._physics._subatomic.bosons.Photon

interface IParticleBeam : IBeam {
             fun emit               ()                              : Photon
    override fun getClassId         ()                              : String
             fun add                (particle: IParticle)            : IParticle
    override operator fun get       (pos:Int)                       : IParticle
             fun getParticleCore    ()                              : Array<IParticle>
             fun set                (pos:Int, particle: IParticle)  : IParticle
}