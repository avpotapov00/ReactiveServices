package info.potapov.reactiveservices.exception

class CurrencyNotFoundException(string: String) : Exception("Currency $string not found")