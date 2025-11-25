import random
from sqlalchemy import create_engine, MetaData, Table, Column, Integer, String, select, insert, update
engine = create_engine('mysql://root:password@localhost/mydb2')
metadata = MetaData()
connection = engine.connect()

users = Table(
    'users', metadata,
    Column('id', Integer, primary_key=True),
    Column('name', String()),
    Column('email', String())
)
metadata.create_all(engine)
# #
inst_stmt = insert(users).values(id=500, name='name', email='name500@email.com')
result = connection.execute(inst_stmt)
print(result.lastrowid)


new_id = random.randint(1, 500)
updt_stmt = update(users).where(users.c.id == 500).values(id=new_id, email=f'name{new_id}email.com')
result = connection.execute(updt_stmt)


stmt = select(users).where(users.c.email.like('%@%'))
stmt = select(users)
result_set = connection.execute(stmt)
# print(result_set.fetchall())
for row in result_set:
    print(row)

connection.commit()
connection.close()
