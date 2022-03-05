cd frontend/my-app
npm install
npm run build
cd ../..
rm -rf ./static
cp -r frontend/my-app/build ./static
./mvnw spring-boot:run