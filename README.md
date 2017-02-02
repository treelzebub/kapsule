# knapsack

A small Kotlin library of convenience code for Android Developers.

Makes one-liners out of displaying Toasts; editing SharedPreferences; starting Activities with an optional Bundle; setting View visibility based on a predicate; and more!

KDoc coming soon, though most of this is pretty self-explanatory.

### Examples:
#### This:
```
val intent = Intent(this, AnotherActivity::class.java)
intent.putExtras(bundle)
startActivity(intent)
```
#### Becomes:
`startActivity<AnotherActivity>(bundle)`

#### This:
```
override fun onCreateViewHolder(parent: ViewGroup): MyViewHolder {
  val inflater = LayoutInflater.from(parent.context)
  val view = inflater.inflate(R.layout.my_layout, parent, false)
  return MyViewHolder(view)
}
```
#### Becomes:
```
override fun onCreateViewHolder(parent: ViewGroup): MyViewHolder {
  return MyViewHolder(parent.inflate(R.layout.my_layout))
}
```
