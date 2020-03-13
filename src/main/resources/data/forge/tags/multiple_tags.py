metals = ["Aluminum", "Copper", "Lead", "Nickel", "Platinum", "Silver", "Tin"]
metals.reverse()
for i in metals:
    f = open(i.lower() + ".json", "w")
    f.writelines(
        '''
{
  "replace": false,
  "values": [
    "extensiveengineering:''' + i.lower() + '''_block"
  ]
}
        '''
    )