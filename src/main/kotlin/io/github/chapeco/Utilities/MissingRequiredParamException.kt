package io.github.chapeco.Utilities

class MissingRequiredParamException(param: String): Exception(param)
{
    override val message: String?
        get() = super.message + " parameter must be set for this request!"
}