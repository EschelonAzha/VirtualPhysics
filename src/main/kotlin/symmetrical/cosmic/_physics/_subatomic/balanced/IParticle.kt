package symmetrical.cosmic._physics._subatomic.balanced


interface IParticle {
    fun createUniqueId()                    : IParticle
    fun getUniqueId   ()                    : String
    fun getClassId    ()                    : String
    fun setParent     (parent: IParticle)    : IParticle
}